package com.tui.proof.order.service;

import com.tui.proof.notification.NotificationService;
import com.tui.proof.order.Order;
import com.tui.proof.order.mapping.OrderMapper;
import com.tui.proof.order.repository.OrderRepository;
import com.tui.proof.order.request.OrderCreateRequest;
import com.tui.proof.order.request.OrderUpdateRequest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
  private final OrderMapper orderMapper;
  private final OrderRepository orderRepository;
  private final NotificationService notificationService;

  public List<Order> getAll() {
    return orderRepository.findAll();
  }

  public Order create(OrderCreateRequest createRequest) {
    Order order = orderMapper.toOrderModel(createRequest);
    Order savedOrder = orderRepository.save(order);
    notificationService.notifyOfNewOrder(savedOrder);
    return savedOrder;
  }

  public Order update(OrderUpdateRequest orderUpdateRequest) throws OrderNotUpdatableException {
    Optional<Order> optionalOrder =
        orderRepository.findById(UUID.fromString(orderUpdateRequest.getUuid()));
    if (optionalOrder.isPresent()) {
      if (isUpdatable(optionalOrder.get())) {
        Order updatedOrder =
            orderRepository.save(orderMapper.toOrderModel(orderUpdateRequest, optionalOrder.get()));
        notificationService.notifyOfUpdatedOrder(updatedOrder);
        return updatedOrder;
      } else {
        throw new OrderNotUpdatableException();
      }
    } else {
      throw new EntityNotFoundException();
    }
  }

  private boolean isUpdatable(Order order) {
    return ChronoUnit.MINUTES.between(order.getCreatedDate(), LocalDateTime.now()) < 5;
  }
}

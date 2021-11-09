package com.tui.proof.order.service;

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

  public List<Order> getAll() {
    return orderRepository.findAll();
  }

  public Order create(OrderCreateRequest createRequest) {
    Order order = orderMapper.toOrderModel(createRequest);
    return orderRepository.save(order);
  }

  public Order update(OrderUpdateRequest orderUpdateRequest) throws OrderNotUpdatableException {
    Optional<Order> optionalOrder =
        orderRepository.findById(UUID.fromString(orderUpdateRequest.getUuid()));
    if (optionalOrder.isPresent()) {
      if (isUpdatable(optionalOrder.get())) {
        return orderRepository.save(
            orderMapper.toOrderModel(orderUpdateRequest, optionalOrder.get()));
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

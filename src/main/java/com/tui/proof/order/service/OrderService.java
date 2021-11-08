package com.tui.proof.order.service;

import com.tui.proof.order.Order;
import com.tui.proof.order.mapping.OrderMapper;
import com.tui.proof.order.repository.OrderRepository;
import com.tui.proof.order.request.OrderCreateRequest;
import com.tui.proof.order.request.OrderUpdateRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
  private final OrderMapper orderMapper;
  private final OrderRepository repository;

  public List<Order> getAll() {
    return repository.findAll();
  }

  public Order create(OrderCreateRequest createRequest) {
    Order order = orderMapper.toOrderModel(createRequest);
    return repository.save(order);
  }

  public Order update(OrderUpdateRequest orderCreateRequest) {
    return null;
  }
}

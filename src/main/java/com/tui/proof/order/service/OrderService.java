package com.tui.proof.order.service;

import com.tui.proof.order.Order;
import com.tui.proof.order.mapping.OrderMapping;
import com.tui.proof.order.repository.OrderRepository;
import com.tui.proof.order.response.OrderResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
  private final OrderMapping orderMapping;
  private final OrderRepository repository;

  public List<OrderResponse> getAll() {
    List<Order> allOrders = repository.findAll();
    return orderMapping.toOrderResponseList(allOrders);
  }
}

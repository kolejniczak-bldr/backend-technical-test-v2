package com.tui.proof.ws.controller;

import com.tui.proof.order.Order;
import com.tui.proof.order.mapping.OrderMapper;
import com.tui.proof.order.request.OrderCreateRequest;
import com.tui.proof.order.request.OrderUpdateRequest;
import com.tui.proof.order.response.OrderResponse;
import com.tui.proof.order.service.OrderService;
import com.tui.proof.ws.security.AccessToken;
import com.tui.proof.ws.security.InvalidTokenException;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;
  private final OrderMapper orderMapper;

  @GetMapping
  public List<OrderResponse> getAllOrders(
      @RequestHeader(HttpHeaders.AUTHORIZATION) AccessToken token) throws InvalidTokenException {
    if (!token.isValid()) {
      throw new InvalidTokenException();
    }
    List<Order> orderList = orderService.getAll();
    return orderMapper.toOrderResponseList(orderList);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public OrderResponse createOrder(@Valid @RequestBody OrderCreateRequest orderCreateRequest) {
    Order order = orderService.create(orderCreateRequest);
    return orderMapper.toOrderResponse(order);
  }
}

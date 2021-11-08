package com.tui.proof.ws.controller;

import com.tui.proof.order.response.OrderResponse;
import com.tui.proof.order.service.OrderService;
import com.tui.proof.ws.InvalidTokenException;
import com.tui.proof.ws.order.AccessToken;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @GetMapping
  public List<OrderResponse> test(@RequestHeader(HttpHeaders.AUTHORIZATION) AccessToken token)
      throws InvalidTokenException {
    if (!token.isValid()) {
      throw new InvalidTokenException();
    }

    return orderService.getAll();
  }
}

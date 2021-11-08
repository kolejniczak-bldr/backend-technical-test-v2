package com.tui.proof.order.mapping;

import com.tui.proof.order.Order;
import com.tui.proof.order.request.OrderCreateRequest;
import com.tui.proof.order.response.OrderResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapping {

  OrderResponse toOrderResponseList(Order order);

  Order toOrderModel(OrderCreateRequest createRequest);

  List<OrderResponse> toOrderResponseList(List<Order> allOrders);
}

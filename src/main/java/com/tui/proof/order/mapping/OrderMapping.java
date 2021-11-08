package com.tui.proof.order.mapping;

import com.tui.proof.order.Order;
import com.tui.proof.order.request.OrderCreateRequest;
import com.tui.proof.order.response.OrderResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapping {

  OrderResponse toOrderResponseList(Order order);

  @Mapping(target = "uuid", ignore = true)
  @Mapping(target = "number", ignore = true)
  @Mapping(target = "createdDate", ignore = true)
  Order toOrderModel(OrderCreateRequest createRequest);

  List<OrderResponse> toOrderResponseList(List<Order> allOrders);
}

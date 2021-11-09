package com.tui.proof.order.mapping;

import com.tui.proof.address.AddressMapper;
import com.tui.proof.client.ClientMapper;
import com.tui.proof.order.Order;
import com.tui.proof.order.request.OrderCreateRequest;
import com.tui.proof.order.request.OrderUpdateRequest;
import com.tui.proof.order.response.OrderResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    uses = {ClientMapper.class, AddressMapper.class})
public interface OrderMapper {

  @Mapping(target = "uuid", ignore = true)
  @Mapping(target = "readableNumber", ignore = true)
  @Mapping(target = "createdDate", ignore = true)
  Order toOrderModel(OrderCreateRequest createRequest);

  @Mapping(target = "readableNumber", source = "original.readableNumber")
  @Mapping(target = "createdDate", source = "original.createdDate")
  @Mapping(target = "uuid", source = "original.uuid")
  @Mapping(target = "deliveryAddress", source = "createRequest.deliveryAddress")
  @Mapping(target = "pilotes", source = "createRequest.pilotes")
  @Mapping(target = "orderTotal", source = "createRequest.orderTotal")
  @Mapping(target = "client", source = "createRequest.client")
  Order toOrderModel(OrderUpdateRequest createRequest, Order original);

  List<OrderResponse> toOrderResponseList(List<Order> allOrders);

  OrderResponse toOrderResponse(Order order);
}

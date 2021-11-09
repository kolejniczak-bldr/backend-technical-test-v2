package com.tui.proof.order.request;

import com.tui.proof.order.dto.AddressDTO;
import com.tui.proof.order.dto.ClientDTO;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class OrderUpdateRequest extends OrderCreateRequest {
  @NotNull private String uuid;

  public OrderUpdateRequest(
      @NotNull @Valid ClientDTO client,
      @NotNull @Valid AddressDTO deliveryAddress,
      int pilotes,
      @Positive double orderTotal) {
    super(client, deliveryAddress, pilotes, orderTotal);
  }
}

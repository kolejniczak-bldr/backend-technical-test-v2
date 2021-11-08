package com.tui.proof.order.request;

import com.tui.proof.order.PilotesValidation;
import com.tui.proof.order.dto.AddressDTO;
import com.tui.proof.order.dto.ClientDTO;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderCreateRequest {
  @NotNull @Valid private final ClientDTO client;

  @NotNull @Valid private final AddressDTO deliveryAddress;

  @PilotesValidation private final int pilotes;

  @Positive private final double orderTotal;
}

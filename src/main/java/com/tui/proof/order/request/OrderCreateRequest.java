package com.tui.proof.order.request;

import com.tui.proof.model.Address;
import com.tui.proof.model.Client;
import com.tui.proof.order.OrderValidation;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@OrderValidation
public class OrderCreateRequest {
  private Client client;

  @Valid private Address deliveryAddress;

  @Positive private int pilotes;

  @Positive private double orderTotal;
}

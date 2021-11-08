package com.tui.proof.order.response;

import com.tui.proof.model.Address;
import java.util.UUID;
import lombok.Data;

@Data
public class OrderResponse {
  private final UUID uuid;
  private final String number;
  private final Address deliveryAddress;
  private final int pilotes;
  private final double orderTotal;
}

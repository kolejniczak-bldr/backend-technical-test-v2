package com.tui.proof.order.response;

import com.tui.proof.order.dto.AddressDTO;
import com.tui.proof.order.dto.ClientDTO;
import java.util.UUID;
import lombok.Data;

@Data
public class OrderResponse {
  private final UUID uuid;
  private final String readableNumber;
  private final AddressDTO deliveryAddress;
  private final ClientDTO client;
  private final int pilotes;
  private final double orderTotal;
}

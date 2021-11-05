package com.tui.proof.order;

import com.tui.proof.model.Address;
import com.tui.proof.model.Client;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "orders")
public class Order {

  @Column(name = "number")
  private String number;

  @Column(name = "delivery_address")
  private Address deliveryAddress;

  @Column(name = "pilotes")
  private int pilotes;

  @Column(name = "order_total")
  private double orderTotal;

  @ManyToOne Client client;
}

package com.tui.proof.order;

import com.tui.proof.model.Address;
import com.tui.proof.model.Client;
import com.tui.proof.ws.ModelWithId;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends ModelWithId {
  @CreatedDate
  @Column(name = "created_date")
  LocalDateTime createdDate = LocalDateTime.now();

  @Column(name = "number")
  private String number;

  @ManyToOne private Address deliveryAddress;

  @Column(name = "pilotes")
  private int pilotes;

  @Column(name = "order_total")
  private double orderTotal;

  @ManyToOne @CreatedBy Client client;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Order order = (Order) o;
    return pilotes == order.pilotes
        && Double.compare(order.orderTotal, orderTotal) == 0
        && createdDate.equals(order.createdDate)
        && number.equals(order.number)
        && deliveryAddress.equals(order.deliveryAddress)
        && client.equals(order.client);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(), createdDate, number, deliveryAddress, pilotes, orderTotal, client);
  }
}

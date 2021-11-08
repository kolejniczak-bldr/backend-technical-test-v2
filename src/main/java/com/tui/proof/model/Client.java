package com.tui.proof.model;

import com.tui.proof.order.ModelWithId;
import com.tui.proof.order.Order;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "clients")
@Entity
public class Client extends ModelWithId {

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "telephone")
  private String telephone;

  @OneToMany @JoinTable @ToString.Exclude List<Order> orders;

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
    Client client = (Client) o;
    return firstName.equals(client.firstName)
        && lastName.equals(client.lastName)
        && telephone.equals(client.telephone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), firstName, lastName, telephone);
  }
}

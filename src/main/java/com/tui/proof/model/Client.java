package com.tui.proof.model;

import com.tui.proof.order.Order;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "clients")
public class Client {

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "telephone")
  private String telephone;

  @OneToMany @JoinTable List<Order> orders;
}

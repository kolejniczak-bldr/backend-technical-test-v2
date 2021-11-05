package com.tui.proof.model;

import javax.persistence.Column;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "addresses")
public class Address {
  @Column(name = "street")
  private String street;

  @Column(name = "postcode")
  private String postcode;

  @Column(name = "city")
  private String city;

  @Column(name = "country")
  private String country;
}

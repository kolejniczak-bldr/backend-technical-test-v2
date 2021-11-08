package com.tui.proof.model;

import com.tui.proof.ws.ModelWithId;
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
@Entity
@Table(name = "addresses")
public class Address extends ModelWithId {
  @Column(name = "street")
  private String street;

  @Column(name = "postcode")
  private String postcode;

  @Column(name = "city")
  private String city;

  @Column(name = "country")
  private String country;

  @OneToMany @JoinTable @ToString.Exclude private List<Address> addresses;

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
    Address address = (Address) o;
    return street.equals(address.street)
        && postcode.equals(address.postcode)
        && city.equals(address.city)
        && country.equals(address.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), street, postcode, city, country);
  }
}

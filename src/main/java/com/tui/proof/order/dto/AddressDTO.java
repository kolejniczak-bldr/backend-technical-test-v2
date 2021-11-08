package com.tui.proof.order.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressDTO {
  @NotEmpty private final String street;

  @NotEmpty
  @Pattern(regexp = "\\d{2,3}-\\d{2,3}")
  private final String postcode;

  @NotEmpty private final String city;

  @NotEmpty private final String country;
}

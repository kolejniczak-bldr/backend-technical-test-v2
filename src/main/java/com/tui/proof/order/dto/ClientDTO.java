package com.tui.proof.order.dto;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ClientDTO {
  @NotEmpty private final String firstName;
  @NotEmpty private final String lastName;
  @NotEmpty private final String telephone;
}

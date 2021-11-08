package com.tui.proof.address;

import com.tui.proof.model.Address;
import com.tui.proof.order.dto.AddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {
  AddressDTO toAddressDTO(Address address);

  @Mapping(target = "uuid", ignore = true)
  @Mapping(target = "orders", ignore = true)
  Address fromAddressDTO(AddressDTO addressDTO);
}

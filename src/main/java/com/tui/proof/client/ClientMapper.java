package com.tui.proof.client;

import com.tui.proof.model.Client;
import com.tui.proof.order.dto.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {
  ClientDTO toClientDTO(Client client);

  @Mapping(target = "uuid", ignore = true)
  @Mapping(target = "orders", ignore = true)
  Client fromClientDTO(ClientDTO client);
}

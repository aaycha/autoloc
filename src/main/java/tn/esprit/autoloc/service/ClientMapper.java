package tn.esprit.autoloc.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.web.dto.ClientDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDTO toDto(Client client);

    @Mapping(target = "idClient", ignore = true)
    @Mapping(target = "numPermis", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    Client toEntity(ClientDTO clientDTO);

    List<ClientDTO> toDtoList(List<Client> clients);

    List<Client> toEntityList(List<ClientDTO> dtos);
}

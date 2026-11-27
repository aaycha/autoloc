package tn.esprit.autoloc.web.dto;

import org.mapstruct.Mapper;
import tn.esprit.autoloc.domain.Agence;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgenceMapper {

    AgenceDTO toDto(Agence agence);

    Agence toEntity(AgenceDTO agenceDTO);

    List<AgenceDTO> toDtoList(List<Agence> agences);

    List<Agence> toEntityList(List<AgenceDTO> dtos);
}

package tn.esprit.autoloc.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.web.dto.AgenceDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-11-27T11:25:52+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.11 (Oracle Corporation)"
)
@Component
public class AgenceMapperImpl implements AgenceMapper {

    @Override
    public AgenceDTO toDto(Agence agence) {
        if ( agence == null ) {
            return null;
        }

        AgenceDTO.AgenceDTOBuilder agenceDTO = AgenceDTO.builder();

        agenceDTO.idAgence( agence.getIdAgence() );
        agenceDTO.nom( agence.getNom() );
        agenceDTO.ville( agence.getVille() );
        agenceDTO.adresse( agence.getAdresse() );
        agenceDTO.telephone( agence.getTelephone() );

        return agenceDTO.build();
    }

    @Override
    public Agence toEntity(AgenceDTO agenceDTO) {
        if ( agenceDTO == null ) {
            return null;
        }

        Agence agence = new Agence();

        agence.setIdAgence( agenceDTO.getIdAgence() );
        agence.setNom( agenceDTO.getNom() );
        agence.setVille( agenceDTO.getVille() );
        agence.setAdresse( agenceDTO.getAdresse() );
        agence.setTelephone( agenceDTO.getTelephone() );

        return agence;
    }

    @Override
    public List<AgenceDTO> toDtoList(List<Agence> agences) {
        if ( agences == null ) {
            return null;
        }

        List<AgenceDTO> list = new ArrayList<AgenceDTO>( agences.size() );
        for ( Agence agence : agences ) {
            list.add( toDto( agence ) );
        }

        return list;
    }

    @Override
    public List<Agence> toEntityList(List<AgenceDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Agence> list = new ArrayList<Agence>( dtos.size() );
        for ( AgenceDTO agenceDTO : dtos ) {
            list.add( toEntity( agenceDTO ) );
        }

        return list;
    }
}

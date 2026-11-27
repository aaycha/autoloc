package tn.esprit.autoloc.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.web.dto.ClientDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-11-27T11:25:52+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.11 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDTO toDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDTO.ClientDTOBuilder clientDTO = ClientDTO.builder();

        clientDTO.nom( client.getNom() );
        clientDTO.prenom( client.getPrenom() );
        clientDTO.email( client.getEmail() );
        clientDTO.telephone( client.getTelephone() );
        clientDTO.dateInscription( client.getDateInscription() );

        return clientDTO.build();
    }

    @Override
    public Client toEntity(ClientDTO clientDTO) {
        if ( clientDTO == null ) {
            return null;
        }

        Client client = new Client();

        client.setNom( clientDTO.getNom() );
        client.setPrenom( clientDTO.getPrenom() );
        client.setEmail( clientDTO.getEmail() );
        client.setTelephone( clientDTO.getTelephone() );
        client.setDateInscription( clientDTO.getDateInscription() );

        return client;
    }

    @Override
    public List<ClientDTO> toDtoList(List<Client> clients) {
        if ( clients == null ) {
            return null;
        }

        List<ClientDTO> list = new ArrayList<ClientDTO>( clients.size() );
        for ( Client client : clients ) {
            list.add( toDto( client ) );
        }

        return list;
    }

    @Override
    public List<Client> toEntityList(List<ClientDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( dtos.size() );
        for ( ClientDTO clientDTO : dtos ) {
            list.add( toEntity( clientDTO ) );
        }

        return list;
    }
}

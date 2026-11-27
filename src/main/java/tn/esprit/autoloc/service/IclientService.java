package tn.esprit.autoloc.service;

import tn.esprit.autoloc.web.dto.ClientDTO;

import java.util.List;

public interface IclientService {
    List<ClientDTO> retrieveAllClients();
    ClientDTO addClient(ClientDTO c);
    ClientDTO updateClient(ClientDTO c);
    ClientDTO updateClient(Long id, ClientDTO c);
    ClientDTO retrieveClient(Long idClient);
    void removeClient(Long idClient);
    List<ClientDTO> addClients(List<ClientDTO> clients);
}

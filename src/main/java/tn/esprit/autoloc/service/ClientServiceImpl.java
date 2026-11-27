package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;
import tn.esprit.autoloc.web.dto.ClientDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IclientService {

    private final ClientRepository CR;
    private final ClientMapper mapper;

    @Override
    public List<ClientDTO> retrieveAllClients() {
        List<Client> clients = (List<Client>) CR.findAll();
        return mapper.toDtoList(clients);
    }

    @Override
    public ClientDTO addClient(ClientDTO c) {
        Client client = mapper.toEntity(c);
        Client saved = CR.save(client);
        return mapper.toDto(saved);
    }

    @Override
    public ClientDTO updateClient(ClientDTO c) {
        Client client = mapper.toEntity(c);
        Client updated = CR.save(client);
        return mapper.toDto(updated);
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO c) {
        Client client = CR.findById(id).orElse(null);
        if (client != null) {
            client.setNom(c.getNom());
            client.setPrenom(c.getPrenom());
            client.setEmail(c.getEmail());
            client.setTelephone(c.getTelephone());
            client.setDateInscription(c.getDateInscription());
            Client updated = CR.save(client);
            return mapper.toDto(updated);
        }
        return null;
    }

    @Override
    public ClientDTO retrieveClient(Long idClient) {
        Client client = CR.findById(idClient).orElse(null);
        return mapper.toDto(client);
    }

    @Override
    public void removeClient(Long idClient) {
        CR.deleteById(idClient);
    }

    @Override
    public List<ClientDTO> addClients(List<ClientDTO> clients) {
        List<Client> entities = mapper.toEntityList(clients);
        List<Client> saved = (List<Client>) CR.saveAll(entities);
        return mapper.toDtoList(saved);
    }
}

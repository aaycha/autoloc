package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.service.IclientService;
import tn.esprit.autoloc.web.dto.ClientDTO;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IclientService clientService;

    @GetMapping
    public List<ClientDTO> retrieveAllClients() {
        return clientService.retrieveAllClients();
    }

    @GetMapping("/{id}")
    public ClientDTO retrieveClient(@PathVariable Long id) {
        return clientService.retrieveClient(id);
    }

    @PostMapping
    public ClientDTO addClient(@RequestBody ClientDTO clientDTO) {
        return clientService.addClient(clientDTO);
    }

    @PutMapping("/{id}")
    public ClientDTO updateClient(
            @PathVariable Long id,
            @RequestBody ClientDTO clientDTO) {
        return clientService.updateClient(id, clientDTO);
    }

    @DeleteMapping("/{id}")
    public void removeClient(@PathVariable Long id) {
        clientService.removeClient(id);
    }

    @PostMapping("/batch")
    public List<ClientDTO> addClients(@RequestBody List<ClientDTO> clients) {
        return clientService.addClients(clients);
    }
}

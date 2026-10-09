package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IclientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IclientService clientService;

    @GetMapping
    public List<Client> retrieveAllClients() {
        return clientService.retrieveAllClients();
    }

    @GetMapping("/{id}")
    public Client retrieveClient(@PathVariable Long id) {
        return clientService.retrieveClient(id);
    }

    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(
            @PathVariable Long id,
            @RequestBody Client client) {
        client.setIdClient(id);
        return clientService.updateClient(client);
    }

    @DeleteMapping("/{id}")
    public void removeClient(@PathVariable Long id) {
        clientService.removeClient(id);
    }

    @PostMapping("/batch")
    public List<Client> addClients(@RequestBody List<Client> clients) {
        return clientService.addClients(clients);
    }
}


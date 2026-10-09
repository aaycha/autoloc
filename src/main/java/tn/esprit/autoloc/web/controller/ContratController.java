package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@RequestMapping("/contrats")
@RequiredArgsConstructor
public class ContratController {

    private final IContratService contratService;

    // READ : afficher tous les contrats
    @GetMapping
    public List<Contrat> retrieveAllContrats() {
        return contratService.retrieveAllContrats();
    }

    // READ : rechercher un contrat par son ID
    @GetMapping("/{id}")
    public Contrat retrieveContrat(@PathVariable Long id) {
        return contratService.retrieveContrat(id);
    }

    // CREATE : ajouter un contrat
    @PostMapping
    public Contrat addContrat(@RequestBody Contrat contrat) {
        return contratService.addContrat(contrat);
    }

    // UPDATE : modifier un contrat
    @PutMapping("/{id}")
    public Contrat updateContrat(
            @PathVariable Long id,
            @RequestBody Contrat contrat) {

        contrat.setIdContrat(id);
        return contratService.updateContrat(contrat);
    }

    // DELETE : supprimer un contrat
    @DeleteMapping("/{id}")
    public void removeContrat(@PathVariable Long id) {
        contratService.removeContrat(id);
    }

    // CREATE : ajouter plusieurs contrats
    @PostMapping("/batch")
    public List<Contrat> addContrats(
            @RequestBody List<Contrat> contrats) {
        return contratService.addContrats(contrats);
    }
}

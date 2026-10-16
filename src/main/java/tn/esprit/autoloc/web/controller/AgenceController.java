
package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/agences")
@RequiredArgsConstructor
public class AgenceController {

    private final IAgenceService agenceService;

    // READ : récupérer toutes les agences
    @GetMapping
    public List<Agence> retrieveAllAgences() {
        return agenceService.retrieveAllAgences();
    }

    // READ : récupérer une agence par son ID
    @GetMapping("/{id}")
    public Agence retrieveAgence(@PathVariable Long id) {
        return agenceService.retrieveAgence(id);
    }

    // CREATE : ajouter une agence
    @PostMapping
    public Agence addAgence(@RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    // UPDATE : modifier une agence
    @PutMapping("/{id}")
    public Agence updateAgence(
            @PathVariable Long id,
            @RequestBody Agence agence) {
        agence.setIdAgence(id);
        return agenceService.updateAgence(agence);
    }

    // DELETE : supprimer une agence
    @DeleteMapping("/{id}")
    public void removeAgence(@PathVariable Long id) {
        agenceService.removeAgence(id);
    }

    // CREATE : ajouter plusieurs agences
    @PostMapping("/batch")
    public List<Agence> addAgences(@RequestBody List<Agence> agences) {
        return agenceService.addAgences(agences);
    }
}

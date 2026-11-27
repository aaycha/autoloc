package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.service.IAgenceService;
import tn.esprit.autoloc.web.dto.AgenceDTO;

import java.util.List;

@RestController
@RequestMapping("/agences")
@RequiredArgsConstructor
public class AgenceController {

    private final IAgenceService agenceService;

    // READ : récupérer toutes les agences
    @GetMapping
    public List<AgenceDTO> retrieveAllAgences() {
        return agenceService.retrieveAllAgences();
    }

    // READ : récupérer une agence par son ID
    @GetMapping("/{id}")
    public AgenceDTO retrieveAgence(@PathVariable Long id) {
        return agenceService.retrieveAgence(id);
    }

    // CREATE : ajouter une agence
    @PostMapping
    public AgenceDTO addAgence(@RequestBody AgenceDTO agenceDTO) {
        return agenceService.addAgence(agenceDTO);
    }

    // UPDATE : modifier une agence
    @PutMapping("/{id}")
    public AgenceDTO updateAgence(
            @PathVariable Long id,
            @RequestBody AgenceDTO agenceDTO) {
        agenceDTO.setIdAgence(id);
        return agenceService.updateAgence(agenceDTO);
    }

    // DELETE : supprimer une agence
    @DeleteMapping("/{id}")
    public void removeAgence(@PathVariable Long id) {
        agenceService.removeAgence(id);
    }

    // CREATE : ajouter plusieurs agences
    @PostMapping("/batch")
    public List<AgenceDTO> addAgences(@RequestBody List<AgenceDTO> agences) {
        return agenceService.addAgences(agences);
    }

    // Scénario 4 : Rechercher les agences par ville
    @GetMapping("/search/ville/{ville}")
    public List<AgenceDTO> findByVille(@PathVariable String ville) {
        return agenceService.findByVille(ville);
    }
}

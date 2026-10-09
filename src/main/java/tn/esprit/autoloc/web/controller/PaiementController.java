package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final IPaiementService paiementService;

    // READ : afficher tous les paiements
    @GetMapping
    public List<Paiement> retrieveAllPaiements() {
        return paiementService.retrieveAllPaiements();
    }

    // READ : rechercher un paiement par son ID
    @GetMapping("/{id}")
    public Paiement retrievePaiement(@PathVariable Long id) {
        return paiementService.retrievePaiement(id);
    }

    // CREATE : ajouter un paiement
    @PostMapping
    public Paiement addPaiement(@RequestBody Paiement paiement) {
        return paiementService.addPaiement(paiement);
    }

    // UPDATE : modifier un paiement
    @PutMapping("/{id}")
    public Paiement updatePaiement(
            @PathVariable Long id,
            @RequestBody Paiement paiement) {

        paiement.setIdPaiement(id);
        return paiementService.updatePaiement(paiement);
    }

    // DELETE : supprimer un paiement
    @DeleteMapping("/{id}")
    public void removePaiement(@PathVariable Long id) {
        paiementService.removePaiement(id);
    }

    // CREATE : ajouter plusieurs paiements
    @PostMapping("/batch")
    public List<Paiement> addPaiements(
            @RequestBody List<Paiement> paiements) {
        return paiementService.addPaiements(paiements);
    }
}

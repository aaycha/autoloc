
package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/vehicules")
@RequiredArgsConstructor
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    // READ : récupérer tous les véhicules
    @GetMapping
    public List<Vehicule> retrieveAllVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    // READ : récupérer un véhicule par son ID
    @GetMapping("/{id}")
    public Vehicule retrieveVehicule(@PathVariable Long id) {
        return vehiculeService.retrieveVehicule(id);
    }

    // CREATE : ajouter un véhicule
    @PostMapping
    public Vehicule addVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }

    // UPDATE : modifier un véhicule
    @PutMapping("/{id}")
    public Vehicule updateVehicule(
            @PathVariable Long id,
            @RequestBody Vehicule vehicule) {
        vehicule.setIdVehicule(id);
        return vehiculeService.updateVehicule(vehicule);
    }

    // DELETE : supprimer un véhicule
    @DeleteMapping("/{id}")
    public void removeVehicule(@PathVariable Long id) {
        vehiculeService.removeVehicule(id);
    }

    // CREATE : ajouter plusieurs véhicules
    @PostMapping("/batch")
    public List<Vehicule> addVehicules(
            @RequestBody List<Vehicule> vehicules) {
        return vehiculeService.addVehicules(vehicules);
    }
}

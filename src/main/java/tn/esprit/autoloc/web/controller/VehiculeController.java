
package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.math.BigDecimal;
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
    @PutMapping("/{idVehicule}/affecter/{idAgence}")
    public Vehicule affecterVehicule(
            @PathVariable Long idVehicule,
            @PathVariable Long idAgence) {

        return vehiculeService.affecterVehicule(idVehicule, idAgence);
    }
    // Affecter un équipement à un véhicule
    @PutMapping("/{idVehicule}/affecterEquipement/{idEquipement}")
    public Vehicule affecterEquipement(
            @PathVariable Long idVehicule,
            @PathVariable Long idEquipement) {

        return vehiculeService.affecterEquipement(idVehicule, idEquipement);
    }

    // Désaffecter un équipement d'un véhicule
    @PutMapping("/{idVehicule}/desaffecterEquipement/{idEquipement}")
    public Vehicule desaffecterEquipement(
            @PathVariable Long idVehicule,
            @PathVariable Long idEquipement) {

        return vehiculeService.desaffecterEquipement(idVehicule, idEquipement);
    }

    // Scénario 1 : Rechercher les véhicules par marque
    @GetMapping("/search/marque/{marque}")
    public List<Vehicule> findByMarque(@PathVariable String marque) {
        return vehiculeService.findByMarque(marque);
    }

    // Scénario 2 : Rechercher les véhicules par catégorie
    @GetMapping("/search/categorie/{categorie}")
    public List<Vehicule> findByCategorie(@PathVariable CategorieVehicule categorie) {
        return vehiculeService.findByCategorie(categorie);
    }

    // Scénario 3 : Rechercher les véhicules disponibles
    @GetMapping("/search/statut/{statut}")
    public List<Vehicule> findByStatut(@PathVariable StatutVehicule statut) {
        return vehiculeService.findByStatut(statut);
    }

    // Scénario 5 : Rechercher les véhicules dont la marque contient une chaîne
    @GetMapping("/search/marque-contient/{marque}")
    public List<Vehicule> findByMarqueContaining(@PathVariable String marque) {
        return vehiculeService.findByMarqueContaining(marque);
    }

    // Scénario 8 : Rechercher les véhicules dont le tarif > 100
    @GetMapping("/search/tarif-superieur/{tarif}")
    public List<Vehicule> findByTarifJournalierGreaterThan(@PathVariable BigDecimal tarif) {
        return vehiculeService.findByTarifJournalierGreaterThan(tarif);
    }

    // Scénario 11 : Rechercher les véhicules par marque ET statut DISPONIBLE
    @GetMapping("/search/marque-statut")
    public List<Vehicule> findByMarqueAndStatut(
            @RequestParam String marque,
            @RequestParam StatutVehicule statut) {
        return vehiculeService.findByMarqueAndStatut(marque, statut);
    }
}

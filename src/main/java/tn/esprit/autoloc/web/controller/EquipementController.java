
package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("/equipements")
@RequiredArgsConstructor
public class EquipementController {

    private final IEquipementService equipementService;

    // READ : récupérer tous les équipements
    @GetMapping
    public List<Equipement> retrieveAllEquipements() {
        return equipementService.retrieveAllEquipements();
    }

    // READ : récupérer un équipement par son ID
    @GetMapping("/{id}")
    public Equipement retrieveEquipement(@PathVariable Long id) {
        return equipementService.retrieveEquipement(id);
    }

    // CREATE : ajouter un équipement
    @PostMapping
    public Equipement addEquipement(@RequestBody Equipement equipement) {
        return equipementService.addEquipement(equipement);
    }

    // UPDATE : modifier un équipement
    @PutMapping("/{id}")
    public Equipement updateEquipement(
            @PathVariable Long id,
            @RequestBody Equipement equipement) {

        equipement.setIdEquipement(id);
        return equipementService.updateEquipement(equipement);
    }

    // DELETE : supprimer un équipement
    @DeleteMapping("/{id}")
    public void removeEquipement(@PathVariable Long id) {
        equipementService.removeEquipement(id);
    }

    // CREATE : ajouter plusieurs équipements
    @PostMapping("/batch")
    public List<Equipement> addEquipements(
            @RequestBody List<Equipement> equipements) {

        return equipementService.addEquipements(equipements);
    }
}

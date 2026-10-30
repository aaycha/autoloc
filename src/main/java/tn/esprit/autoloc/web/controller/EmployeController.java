
package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/employes")
@RequiredArgsConstructor
public class EmployeController {

    private final IEmployeService employeService;

    // READ : récupérer tous les employés
    @GetMapping
    public List<Employe> retrieveAllEmployes() {
        return employeService.retrieveAllEmployes();
    }

    // READ : récupérer un employé par son ID
    @GetMapping("/{id}")
    public Employe retrieveEmploye(@PathVariable Long id) {
        return employeService.retrieveEmploye(id);
    }

    // CREATE : ajouter un employé
    @PostMapping
    public Employe addEmploye(@RequestBody Employe employe) {
        return employeService.addEmploye(employe);
    }

    // UPDATE : modifier un employé
    @PutMapping("/{id}")
    public Employe updateEmploye(
            @PathVariable Long id,
            @RequestBody Employe employe) {
        employe.setIdEmploye(id);
        return employeService.updateEmploye(employe);
    }

    // DELETE : supprimer un employé
    @DeleteMapping("/{id}")
    public void removeEmploye(@PathVariable Long id) {
        employeService.removeEmploye(id);
    }

    // CREATE : ajouter plusieurs employés
    @PostMapping("/batch")
    public List<Employe> addEmployes(
            @RequestBody List<Employe> employes) {
        return employeService.addEmployes(employes);
    }
    @PutMapping("/{idEmploye}/desaffecter")
    public Employe desaffecterEmploye(@PathVariable Long idEmploye) {
        return employeService.desaffecterEmploye(idEmploye);
    }
    @PutMapping("/{idEmploye}/affecter/{idAgence}")
    public Employe affecterEmploye(
            @PathVariable Long idEmploye,
            @PathVariable Long idAgence) {
        return employeService.affecterEmploye(idEmploye, idAgence);
    }
}

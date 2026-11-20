package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    // Scénario 1
    List<Vehicule> findByMarque(String marque);

    // Scénario 2
    List<Vehicule> findByCategorie(CategorieVehicule categorie);

    // Scénario 3
    List<Vehicule> findByStatut(StatutVehicule statut);
}
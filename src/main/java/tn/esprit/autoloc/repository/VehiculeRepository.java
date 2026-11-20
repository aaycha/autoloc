package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import java.math.BigDecimal;
import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    // Scénario 1
    List<Vehicule> findByMarque(String marque);

    // Scénario 2
    List<Vehicule> findByCategorie(CategorieVehicule categorie);

    // Scénario 3
    List<Vehicule> findByStatut(StatutVehicule statut);

    // Scénario 5
    List<Vehicule> findByMarqueContaining(String marque);

    // Scénario 8
    List<Vehicule> findByTarifJournalierGreaterThan(BigDecimal tarif);

    // Scénario 11
    List<Vehicule> findByMarqueAndStatut(String marque, StatutVehicule statut);
}
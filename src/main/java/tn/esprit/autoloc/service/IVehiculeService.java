package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;

import java.math.BigDecimal;
import java.util.List;

public interface IVehiculeService {

    List<Vehicule> retrieveAllVehicules();

    Vehicule addVehicule(Vehicule v);

    Vehicule updateVehicule(Vehicule v);

    Vehicule retrieveVehicule(Long idVehicule);

    void removeVehicule(Long idVehicule);

    List<Vehicule> addVehicules(List<Vehicule> vehicules);
    Vehicule affecterVehicule(Long idVehicule, Long idAgence);
    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);

    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);

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


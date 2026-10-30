package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.VehiculeRepository;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final VehiculeRepository VR;
    private final AgenceRepository AR;
    private final EquipementRepository ER;

    @Override
    public List<Vehicule> retrieveAllVehicules() {
        return VR.findAll();
    }

    @Override
    public Vehicule addVehicule(Vehicule v) {
        return VR.save(v);
    }

    @Override
    public Vehicule updateVehicule(Vehicule v) {
        return VR.save(v);
    }

    @Override
    public Vehicule retrieveVehicule(Long idVehicule) {
        return VR.findById(idVehicule).orElse(null);
    }

    @Override
    public void removeVehicule(Long idVehicule) {
        VR.deleteById(idVehicule);
    }

    @Override
    public List<Vehicule> addVehicules(List<Vehicule> vehicules) {
        return VR.saveAll(vehicules);
    }

    @Override
    public Vehicule affecterVehicule(Long idVehicule, Long idAgence) {

        Vehicule vehicule = VR.findById(idVehicule)
                .orElseThrow(() -> new RuntimeException("Véhicule introuvable"));

        Agence agence = AR.findById(idAgence)
                .orElseThrow(() -> new RuntimeException("Agence introuvable"));

        vehicule.setAgence(agence);

        return VR.save(vehicule);
    }
    @Override
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {

        Vehicule vehicule = VR.findById(idVehicule)
                .orElseThrow(() -> new RuntimeException("Véhicule introuvable"));

        Equipement equipement = ER.findById(idEquipement)
                .orElseThrow(() -> new RuntimeException("Équipement introuvable"));

        if (vehicule.getEquipements() == null) {
            vehicule.setEquipements(new ArrayList<>());
        }

        if (!vehicule.getEquipements().contains(equipement)) {
            vehicule.getEquipements().add(equipement);
        }

        return VR.save(vehicule);
    }

    @Override
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {

        Vehicule vehicule = VR.findById(idVehicule)
                .orElseThrow(() -> new RuntimeException("Véhicule introuvable"));

        Equipement equipement = ER.findById(idEquipement)
                .orElseThrow(() -> new RuntimeException("Équipement introuvable"));

        if (vehicule.getEquipements() != null) {
            vehicule.getEquipements().remove(equipement);
        }

        return VR.save(vehicule);
    }
}
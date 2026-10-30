package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.VehiculeRepository;
import tn.esprit.autoloc.repository.AgenceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final VehiculeRepository VR;
    private final AgenceRepository AR;

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
}
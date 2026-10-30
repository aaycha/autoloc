package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;
import tn.esprit.autoloc.repository.AgenceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    final EmployeRepository ER;
    final AgenceRepository AR;

    @Override
    public List<Employe> retrieveAllEmployes() {
        return (List<Employe>) ER.findAll();
    }

    @Override
    public Employe addEmploye(Employe e) {
        return ER.save(e);
    }

    @Override
    public Employe updateEmploye(Employe e) {
        return ER.save(e);
    }

    @Override
    public Employe retrieveEmploye(Long idEmploye) {
        return ER.findById(idEmploye).orElse(null);
    }

    @Override
    public void removeEmploye(Long idEmploye) {
        ER.deleteById(idEmploye);
    }

    @Override
    public List<Employe> addEmployes(List<Employe> employes) {
        return (List<Employe>) ER.saveAll(employes);
    }
    @Override
    public Employe desaffecterEmploye(Long idEmploye) {

        Employe employe = ER.findById(idEmploye)
                .orElseThrow(() -> new RuntimeException("Employe introuvable"));

        employe.setAgence(null);

        return ER.save(employe);
    }
//AFFECTATION D4UN EMPLOYEE
@Override
public Employe affecterEmploye(Long idEmploye, Long idAgence) {

    Employe employe = ER.findById(idEmploye)
            .orElseThrow(() -> new RuntimeException("Employe introuvable"));

    Agence agence = AR.findById(idAgence)
            .orElseThrow(() -> new RuntimeException("Agence introuvable"));

    employe.setAgence(agence);

    return ER.save(employe);
}
}



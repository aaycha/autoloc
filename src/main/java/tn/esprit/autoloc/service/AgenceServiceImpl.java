package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.web.dto.AgenceDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private final AgenceRepository AR;
    private final AgenceMapper mapper;

    @Override
    public List<AgenceDTO> retrieveAllAgences() {
        List<Agence> agences = (List<Agence>) AR.findAll();
        return mapper.toDtoList(agences);
    }

    @Override
    public AgenceDTO addAgence(AgenceDTO a) {
        Agence agence = mapper.toEntity(a);
        Agence saved = AR.save(agence);
        return mapper.toDto(saved);
    }

    @Override
    public AgenceDTO updateAgence(AgenceDTO a) {
        Agence agence = mapper.toEntity(a);
        Agence updated = AR.save(agence);
        return mapper.toDto(updated);
    }

    @Override
    public AgenceDTO retrieveAgence(Long idAgence) {
        Agence agence = AR.findById(idAgence).orElse(null);
        return mapper.toDto(agence);
    }

    @Override
    public void removeAgence(Long idAgence) {
        AR.deleteById(idAgence);
    }

    @Override
    public List<AgenceDTO> addAgences(List<AgenceDTO> agences) {
        List<Agence> entities = mapper.toEntityList(agences);
        List<Agence> saved = (List<Agence>) AR.saveAll(entities);
        return mapper.toDtoList(saved);
    }

    // Scénario 4
    @Override
    public List<AgenceDTO> findByVille(String ville) {
        List<Agence> agences = AR.findByVille(ville);
        return mapper.toDtoList(agences);
    }
}

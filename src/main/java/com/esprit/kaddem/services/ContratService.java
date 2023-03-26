package com.esprit.kaddem.services;

import com.esprit.kaddem.IServices.IContratService;
import com.esprit.kaddem.entities.Contrat;
import com.esprit.kaddem.repositories.ContratRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratService implements IContratService {
    private final ContratRepository contratRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat addContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void removeContrat(Integer idContrat) {
        contratRepository.deleteById(idContrat);
    }

    @Override
    public Contrat getContratById(Integer contratID) {
        return contratRepository.findById(contratID).orElse(null);
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        List<Contrat> contrats = contratRepository.findContratByDateDebutContratGreaterThanEqualAndDateFinContratLessThanEqualAndArchiveFalse(startDate,endDate);
        return contrats.size();
    }




}

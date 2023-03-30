package com.esprit.kaddem.services;

import com.esprit.kaddem.IServices.IContratService;
import com.esprit.kaddem.entities.Contrat;
import com.esprit.kaddem.repositories.ContratRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
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

    @Override
    @Transactional
    @Scheduled(fixedRate = 60000)
    public void retrieveAndUpdateStatusContrat() {
        log.info(" CONTRATS");
        java.sql.Date localDate = java.sql.Date.valueOf(LocalDate.now().plusDays(15));
        List<Contrat> contratList = contratRepository.findContratsByDateFinContratLessThanEqual(localDate);
        contratList.forEach(contrat -> {
            log.info(" "+contrat.getDateFinContrat()+" "+contrat.getEtudiant().toString()+" "+contrat.getSpecialite());
            System.out.println(java.sql.Date.valueOf(LocalDate.now()));
            System.out.println(contrat.getDateFinContrat());
            if (java.sql.Date.valueOf(LocalDate.now()).equals(contrat.getDateFinContrat())) {
                log.info("UPDATING CONTRATS");
                contrat.setArchive(true);
            }
        });

    }


}

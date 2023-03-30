package com.esprit.kaddem.services;

import com.esprit.kaddem.IServices.IEquipeService;
import com.esprit.kaddem.entities.Equipe;
import com.esprit.kaddem.entities.Etudiant;
import com.esprit.kaddem.entities.Niveau;
import com.esprit.kaddem.repositories.EquipeRepository;
import com.esprit.kaddem.repositories.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EquipeService implements IEquipeService {
    private final EquipeRepository equipeRepository;
    private final EtudiantRepository etudiantRepository;
    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).orElse(null);
    }

    @Override
    @Transactional
    @Scheduled(cron = "0 0 9 ? 1 *")
    public void faireEvoluerEquipe() {
        log.info(" faire evoluer equipe lancé");
        Date localDate = Date.valueOf(LocalDate.now().minusYears(1));
        List<Equipe> equipeList = equipeRepository.getEquipesByEtudiantListContratsDateDebutContratGreaterThanAndNiveauNot(localDate, Niveau.EXPERT);
        equipeList.forEach(equipe -> {
            if(equipe.getEtudiantList().size() >= 3) {
                if(equipe.getNiveau() == Niveau.JUNIOR) {
                    equipe.setNiveau(Niveau.SENIOR);
                    log.info("equipe :"+equipe.getNomEquipe()+", evolué");
                } else if (equipe.getNiveau() == Niveau.SENIOR) {
                    equipe.setNiveau(Niveau.EXPERT);
                    log.info("equipe :"+equipe.getNomEquipe()+", evolué");
                }
            }
        });
    }
}

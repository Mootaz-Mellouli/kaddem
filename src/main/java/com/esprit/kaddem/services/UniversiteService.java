package com.esprit.kaddem.services;

import com.esprit.kaddem.repositories.UniversiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UniversiteService {

    private final UniversiteRepository universiteRepository;

    /*public Map<String,Float> getMontantContartEntreDeuxDate(int idUniv, Date startDate, Date endDate) {
        universiteRepository.getUniversiteByIdUnivAndDepartementsEtudiantOption(idUniv);
        return null;
    }*/
}

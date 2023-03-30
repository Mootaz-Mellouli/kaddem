package com.esprit.kaddem.IServices;

import com.esprit.kaddem.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {
    List<Contrat> retrieveAllContrats();

    Contrat updateContrat (Contrat contrat);

    Contrat addContrat (Contrat contrat);

    void removeContrat(Integer idContrat);

    Contrat getContratById(Integer contratID);

    Integer nbContratsValides(Date startDate, Date endDate);
    void retrieveAndUpdateStatusContrat();
}

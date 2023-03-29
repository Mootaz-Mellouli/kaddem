package com.esprit.kaddem.repositories;

import com.esprit.kaddem.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat,Integer> {

    List<Contrat> findContratByDateDebutContratGreaterThanEqualAndDateFinContratLessThanEqualAndArchiveFalse(Date startDate, Date endDate);
}

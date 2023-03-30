package com.esprit.kaddem.repositories;

import com.esprit.kaddem.entities.Contrat;
import com.esprit.kaddem.entities.Equipe;
import com.esprit.kaddem.entities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {



    List<Equipe> getEquipesByEtudiantListContratsDateDebutContratGreaterThanAndNiveauNot(Date date, Niveau niveau);
}

package com.esprit.kaddem.repositories;

import com.esprit.kaddem.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversiteRepository extends JpaRepository<Universite,Integer> {
    //  Universite getUniversiteByIdUnivAndDepartementsEtudiant(int idUniv);
}

package com.esprit.kaddem.repositories;

import com.esprit.kaddem.entities.Departement;
import com.esprit.kaddem.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {

     Etudiant getEtudiantByPrenomEAndNomE(String prenom,String nom); // JPA Buddy
}

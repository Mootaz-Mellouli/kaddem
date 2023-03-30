package com.esprit.kaddem.repositories;

import com.esprit.kaddem.entities.Departement;
import com.esprit.kaddem.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {

     Etudiant getEtudiantByPrenomEAndNomE(String prenom, String nom);
     List<Etudiant> getEtudiantsByDepartement(Departement departement);

     @Query("select e from Etudiant e inner join e.contrats contrats where contrats.dateDebutContrat > ?1")
     List<Etudiant> getEtudiantsByContratsDateDebutContratGreaterThan(LocalDate date);
}

package com.esprit.kaddem.repositories;

import com.esprit.kaddem.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
}

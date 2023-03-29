package com.esprit.kaddem.repositories;

import com.esprit.kaddem.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DepartementRepository extends JpaRepository<Departement,Integer> {
}

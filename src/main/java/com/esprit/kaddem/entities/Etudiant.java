package com.esprit.kaddem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Etudiant {
    @Id
    private int idEtudiant;
    private String prenomE;
    private String nomE;
    private Option option;
    @OneToMany(mappedBy = "etudiant")
    private List<Contrat> contrats;
    @ManyToMany(mappedBy = "etudiantList")
    private List<Equipe> equipes;
}

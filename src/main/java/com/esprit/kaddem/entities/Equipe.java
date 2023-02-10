package com.esprit.kaddem.entities;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

public class Equipe {
    private int idEquipe;
    private String nomEquipe;
    private Niveau niveau;
    @ManyToMany
    private List<Etudiant> etudiantList;
    @OneToOne
    private DetailEquipe detailEquipe;
}

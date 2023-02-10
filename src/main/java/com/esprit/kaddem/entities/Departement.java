package com.esprit.kaddem.entities;

import jakarta.persistence.OneToMany;

import java.util.List;

public class Departement {
    private int idApart;
    private String nomDepart;
    @OneToMany(mappedBy = "departement")
    private List<Etudiant> etudiantList;
}

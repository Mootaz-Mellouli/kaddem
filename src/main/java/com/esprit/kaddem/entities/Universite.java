package com.esprit.kaddem.entities;

import jakarta.persistence.OneToMany;

import java.util.List;

public class Universite {
    private int idUniv;
    private String nomUniv;

    @OneToMany
    List<Departement> departements;
}

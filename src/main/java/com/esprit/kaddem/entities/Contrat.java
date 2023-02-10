package com.esprit.kaddem.entities;


import jakarta.persistence.ManyToOne;

import java.util.Date;

public class Contrat {
    private int idContrat;
    private Date dateDebutContrat;
    private Date dateFinContrat;
    private boolean archive;
    private int montantContrat;
    private Specialite specialite;
    @ManyToOne
    private Etudiant etudiant;
}

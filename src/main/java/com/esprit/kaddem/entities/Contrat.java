package com.esprit.kaddem.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contrat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContrat;
    private Date dateDebutContrat;
    private Date dateFinContrat;
    private boolean archive;
    private int montantContrat;
    private Specialite specialite;
    @ManyToOne
    private Etudiant etudiant;
}

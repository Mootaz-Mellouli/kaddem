package com.esprit.kaddem.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtudiant;
    private String prenomE;
    private String nomE;
    private Option option;
    @OneToMany(mappedBy = "etudiant")
    @JsonIgnore
    private List<Contrat> contrats;
    @ManyToMany(mappedBy = "etudiantList")
    @JsonIgnore
    private List<Equipe> equipes;
    @ManyToOne
    @JsonIgnore
    private Departement departement;
}

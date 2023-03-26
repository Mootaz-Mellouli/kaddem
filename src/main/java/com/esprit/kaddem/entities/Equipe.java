package com.esprit.kaddem.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquipe;
    private String nomEquipe;
    private Niveau niveau;
    @ManyToMany
    @JsonIgnore
    private List<Etudiant> etudiantList;
    @OneToOne(mappedBy = "equipe")
    private DetailEquipe detailEquipe;
}

package com.esprit.kaddem.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
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

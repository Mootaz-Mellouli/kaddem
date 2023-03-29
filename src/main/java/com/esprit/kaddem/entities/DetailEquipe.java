package com.esprit.kaddem.entities;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetailEquipe {
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int idDetailEquipe;
     private int Salle;
     private String thematique;

     @OneToOne
     private Equipe equipe;
}

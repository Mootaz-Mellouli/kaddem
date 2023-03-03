package com.esprit.kaddem.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Data
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

package com.esprit.kaddem.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departement {
    @Id  @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idApart;
    private String nomDepart;
    @OneToMany (mappedBy = "departement")
    private List<Etudiant> etudiantList;
}

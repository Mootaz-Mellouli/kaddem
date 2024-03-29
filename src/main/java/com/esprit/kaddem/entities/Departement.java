package com.esprit.kaddem.entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Departement {
    @Id  @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idApart;
        private String nomDepart;
    @OneToMany (mappedBy = "departement")
    private List<Etudiant> etudiantList;
}

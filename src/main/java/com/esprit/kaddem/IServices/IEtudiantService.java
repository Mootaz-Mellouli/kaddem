package com.esprit.kaddem.IServices;

import com.esprit.kaddem.entities.Contrat;
import com.esprit.kaddem.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant ajouterEtduiant(Etudiant etudiant);
    Etudiant updateEtudiant(Etudiant etudiant, int id);
    List<Etudiant> getAllEtudiants();
    void deleteEtudiant(int id);
    Etudiant getByIDEtudiant(int id);

    Contrat affectContratToEtudiant (Contrat ce, String nomEtu, String prenomE);
}

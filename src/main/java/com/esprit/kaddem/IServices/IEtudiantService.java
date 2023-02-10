package com.esprit.kaddem.IServices;

import com.esprit.kaddem.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    void ajouterEtduiant(Etudiant etudiant);
    void updateEtudiant(Etudiant etudiant);
    List<Etudiant> getAllEtudiants();
    void deleteEtudiant(int id);
    Etudiant getByIDEtudiant(int id);
}

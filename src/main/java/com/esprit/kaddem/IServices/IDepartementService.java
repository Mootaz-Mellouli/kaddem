package com.esprit.kaddem.IServices;

import com.esprit.kaddem.entities.Departement;
import com.esprit.kaddem.entities.Etudiant;

import java.util.List;

public interface IDepartementService {
    Departement ajouterDepartement(Departement dep);
    Departement updateDepartement(Departement dep, int id);
    List<Departement> getAllDepartements();
    void deleteDepartement(int id);
    Departement getByIDDepartement(int id);
    void assignEtudiantToDepartement (Integer etudiantId, Integer departementId) ;
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
    List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}

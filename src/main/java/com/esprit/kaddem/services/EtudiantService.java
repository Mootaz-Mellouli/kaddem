package com.esprit.kaddem.services;

import com.esprit.kaddem.IServices.IEtudiantService;
import com.esprit.kaddem.entities.Etudiant;
import com.esprit.kaddem.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService implements IEtudiantService {

    private final EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public void ajouterEtduiant(Etudiant etudiant) {
        etudiantRepository.save(etudiant);
    }

    @Override
    public void updateEtudiant(Etudiant etudiant) {

    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public void deleteEtudiant(int id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant getByIDEtudiant(int id) {
        return etudiantRepository.getById(id);
    }
}

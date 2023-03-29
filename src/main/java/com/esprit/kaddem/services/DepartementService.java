package com.esprit.kaddem.services;

import com.esprit.kaddem.IServices.IDepartementService;
import com.esprit.kaddem.entities.Departement;
import com.esprit.kaddem.entities.Etudiant;
import com.esprit.kaddem.entities.Universite;
import com.esprit.kaddem.repositories.DepartementRepository;
import com.esprit.kaddem.repositories.EtudiantRepository;
import com.esprit.kaddem.repositories.UniversiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartementService implements IDepartementService {

    private final DepartementRepository departementRepository ;
    private final EtudiantRepository etudiantRepository;
    private final UniversiteRepository universiteRepository;

    @Override
    public Departement ajouterDepartement(Departement dep) {
        return departementRepository.save(dep);
    }

    @Override
    public Departement updateDepartement(Departement dep, int id) {
        Departement departement = departementRepository.getById(id);
        departement.setNomDepart(dep.getNomDepart());
        departement.setEtudiantList(dep.getEtudiantList());
        return departementRepository.save(departement);
    }

    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public void deleteDepartement(int id) {
        departementRepository.deleteById(id);
    }

    @Override
    public Departement getByIDDepartement(int id) {
        return departementRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
       Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);
       Assert.notNull(etudiant,"etudiant non trouvé");
       Departement departement = departementRepository.findById(departementId).orElse(null);
       Assert.notNull(departement,"departement non trouvé");
       etudiant.setDepartement(departement);
    }

    @Override
    @Transactional
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Assert.notNull(universite,"universite not found");
        Departement departement = departementRepository.findById(idDepartement).orElse(null);
        Assert.notNull(departement,"departement not found");
        universite.getDepartements().add(departement);
    }
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Assert.notNull(universite,"universite not found");
        return universite.getDepartements();
    }

}

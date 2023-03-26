package com.esprit.kaddem.services;

import com.esprit.kaddem.IServices.IDepartementService;
import com.esprit.kaddem.entities.Departement;
import com.esprit.kaddem.entities.Etudiant;
import com.esprit.kaddem.repositories.DepartementRepository;
import com.esprit.kaddem.repositories.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartementService implements IDepartementService {

    private final DepartementRepository departementRepository ;

    private final EtudiantRepository etudiantRepository;

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
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
       Etudiant etudiant = etudiantRepository.getById(etudiantId);
       Assert.notNull(etudiant,"etudiant non trouvé");
       Departement departement = departementRepository.getById(departementId);
       Assert.notNull(departement,"departement non trouvé");
       departement.getEtudiantList().add(etudiant);

    }


}

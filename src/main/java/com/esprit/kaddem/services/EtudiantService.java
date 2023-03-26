package com.esprit.kaddem.services;

import com.esprit.kaddem.IServices.IEtudiantService;
import com.esprit.kaddem.entities.Contrat;
import com.esprit.kaddem.entities.Etudiant;
import com.esprit.kaddem.repositories.ContratRepository;
import com.esprit.kaddem.repositories.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudiantService implements IEtudiantService {

    private final EtudiantRepository etudiantRepository;

    private final ContratRepository contratRepository;

    @Override
    public Etudiant ajouterEtduiant(Etudiant etudiant) {
         return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant, int id) {
        Etudiant etudiant1 = etudiantRepository.getById(id);
        etudiant1.setNomE(etudiant.getNomE());
        etudiant1.setPrenomE(etudiant.getPrenomE());
        etudiant1.setContrats(etudiant.getContrats());
        etudiant1.setDepartement(etudiant.getDepartement());
        etudiant1.setOption(etudiant.getOption());
        etudiant1.setEquipes(etudiant.getEquipes());
        return etudiantRepository.save(etudiant1);
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
        return etudiantRepository.findById(id).get();
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomEtu, String prenomE) {

        Etudiant etudiant = etudiantRepository.getEtudiantByPrenomEAndNomE(nomEtu,prenomE);
        Assert.notNull(etudiant,"not found");
     if(etudiant.getContrats().size() <5) {
         Contrat contrat = contratRepository.getById(ce.getIdContrat());
         contrat.setEtudiant(etudiant);
         return contrat;
      }
        return null;

    }


}

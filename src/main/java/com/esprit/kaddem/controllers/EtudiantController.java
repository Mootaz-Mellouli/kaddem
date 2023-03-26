package com.esprit.kaddem.controllers;

import com.esprit.kaddem.IServices.IEtudiantService;
import com.esprit.kaddem.entities.Contrat;
import com.esprit.kaddem.entities.Etudiant;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "TEST")
@RestController
@RequestMapping({"/etudiant"})
@RequiredArgsConstructor
public class EtudiantController {


    private final IEtudiantService etudiantService;

    @GetMapping("/")
    public List<Etudiant> getAllEtudiants()
    {
        return etudiantService.getAllEtudiants() ;
    }

    @PostMapping ("/add")
    public Etudiant ajouterEtudiant(@RequestBody Etudiant etudiant)
    {
        return etudiantService.ajouterEtduiant(etudiant);
    }
    @GetMapping("/{id}")
    public Etudiant findEtudiantByID(@PathVariable ("id") int id)
    {
        return etudiantService.getByIDEtudiant(id);
    }
    @DeleteMapping({"/{id}"})
    public void deleteEtudiant(@PathVariable("id") int id)
    {
        etudiantService.deleteEtudiant(id);
    }
    @PutMapping({"/{id}"})
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant, @PathVariable("id") int id)
    {

        return etudiantService.updateEtudiant(etudiant,id);
    }
    @RequestMapping("/addContrat/{nomEtu}/{prenomE}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat ce,@PathVariable String nomEtu,@PathVariable String prenomE) {
        etudiantService.affectContratToEtudiant(ce,nomEtu,prenomE);
        return ce;
    }

}

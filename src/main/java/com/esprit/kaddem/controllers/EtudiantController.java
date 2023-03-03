package com.esprit.kaddem.controllers;

import com.esprit.kaddem.IServices.IEtudiantService;
import com.esprit.kaddem.entities.Etudiant;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/etudiant"})
public class EtudiantController {


    private final IEtudiantService etudiantService;

    public EtudiantController(IEtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @RequestMapping("/")
    public List<Etudiant> getAllEtudiants()
    {
        return etudiantService.getAllEtudiants() ;
    }

    @PostMapping ("/add")
    public Etudiant ajouterEtudiant(@RequestBody  Etudiant etudiant)
    {
        return etudiantService.ajouterEtduiant(etudiant);
    }
    @RequestMapping("/{id}")
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

}

package com.esprit.kaddem.controllers;

import com.esprit.kaddem.IServices.IDepartementService;
import com.esprit.kaddem.entities.Departement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/departement"})
@RequiredArgsConstructor
public class DepartementController {

    private final IDepartementService departementService;

    @RequestMapping("/")
    public List<Departement> getAllDepartement()
    {
        return departementService.getAllDepartements() ;
    }

    @PostMapping("/add")
    public Departement ajouterDepartement(@RequestBody Departement departement)
    {
        return departementService.ajouterDepartement(departement);
    }
    @RequestMapping("/{id}")
    public Departement findDepartementByID(@PathVariable("id") int id)
    {
        return departementService.getByIDDepartement(id);
    }
    @DeleteMapping({"/{id}"})
    public void deleteDepartement(@PathVariable("id") int id)
    {
        departementService.deleteDepartement(id);
    }
    @PutMapping({"/{id}"})
    public Departement updateDepartement(@RequestBody Departement departement, @PathVariable("id") int id)
    {

        return departementService.updateDepartement(departement,id);
    }

    @PutMapping("/assignEtudiant/{etudiantId}/{departementId}")
    public void assignEtudiantToDepartement(@PathVariable Integer etudiantId,@PathVariable Integer departementId) {
        departementService.assignEtudiantToDepartement(etudiantId, departementId);
    }
    @PutMapping("/assignUniversite/{idUniversite}/{idDepartement}")
    public void assignUniversiteToDepartement(@PathVariable Integer idUniversite,@PathVariable Integer idDepartement) {
        departementService.assignUniversiteToDepartement(idUniversite, idDepartement);
    }
    @GetMapping("/byUniversite/{idUniversite}")
    public List<Departement> retrieveDepartementsByUniversite(@PathVariable Integer idUniversite) {
        return departementService.retrieveDepartementsByUniversite(idUniversite);
    }
}

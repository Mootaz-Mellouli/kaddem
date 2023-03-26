package com.esprit.kaddem.controllers;

import com.esprit.kaddem.entities.Departement;
import com.esprit.kaddem.entities.Etudiant;
import com.esprit.kaddem.services.DepartementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/departement"})
@RequiredArgsConstructor
public class DepartementController {

    private final DepartementService departementService;

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
}

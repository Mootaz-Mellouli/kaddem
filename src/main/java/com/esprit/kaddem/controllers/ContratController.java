package com.esprit.kaddem.controllers;

import com.esprit.kaddem.IServices.IContratService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contrat")
public class ContratController {
    private final IContratService contratService;

    @RequestMapping("/nbrContratValide/{startDate}/{endDate}")
    public Integer nbContratsValides(@PathVariable Date startDate,@PathVariable Date endDate) {
        return contratService.nbContratsValides(startDate,endDate);
    }
}

package com.prueba.accenture.controllers;

import com.prueba.accenture.dto.FranchisesDto;
import com.prueba.accenture.models.Franchises;
import com.prueba.accenture.services.IFranchisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/franchises")
public class FranchisesController {

    private IFranchisesService franchisesService;

    public FranchisesController(IFranchisesService franchisesService) {
        this.franchisesService = franchisesService;
    }


    @PostMapping("/create")
    public ResponseEntity<Franchises> createFranchise(@RequestBody FranchisesDto franchisesDto) {
        return ResponseEntity.ok(franchisesService.saveFranchise(franchisesDto));
    }

    @GetMapping("/get/all")
    public List<FranchisesDto> getAllFranchises() {
        return franchisesService.getAllFranchises();
    }

    @GetMapping("/get/{id}")
    public FranchisesDto getFranchiseById(@PathVariable int id) {
        return franchisesService.getFranchiseById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFranchise(@PathVariable int id) {
        franchisesService.deleteFranchise(id);
    }

    @PutMapping("/update")
    public void updateFranchise(@RequestBody FranchisesDto franchisesDto) {
        franchisesService.updateFranchise(franchisesDto);
    }
}
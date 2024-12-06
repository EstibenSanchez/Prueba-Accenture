package com.prueba.accenture.controllers;

import com.prueba.accenture.dto.FranchisesDto;
import com.prueba.accenture.dto.SubsidiariesDto;
import com.prueba.accenture.services.ISubsidiariesService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/subsidiaries")
public class SubsidiariesController {

    private ISubsidiariesService subsidiariesService;

    public SubsidiariesController(ISubsidiariesService subsidiariesService) {
        this.subsidiariesService = subsidiariesService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createSubsidiary(@RequestBody SubsidiariesDto subsidiariesDto) {
        System.out.println("SubsidiariesDto: " + subsidiariesDto);
        subsidiariesService.saveSubsidiary(subsidiariesDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateSubsidiary(@RequestBody SubsidiariesDto subsidiariesDto) {
        subsidiariesService.updateSubsidiary(subsidiariesDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSubsidiary(@PathVariable int id) {
        subsidiariesService.deleteSubsidiary(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<SubsidiariesDto>> getAllSubsidiaries() {
        List<SubsidiariesDto> subsidiariesDto = subsidiariesService.getAllSubsidiaries();
        return ResponseEntity.ok(subsidiariesDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SubsidiariesDto> getSubsidiaryById(@PathVariable int id) {
        SubsidiariesDto subsidiariesDto = subsidiariesService.getSubsidiaryById(id);
        return ResponseEntity.ok(subsidiariesDto);
    }

}

package com.prueba.accenture.services.impl;

import com.prueba.accenture.dto.FranchisesDto;
import com.prueba.accenture.dto.SubsidiariesDto;
import com.prueba.accenture.models.Franchises;
import com.prueba.accenture.models.Subsidiaries;
import com.prueba.accenture.repositories.FranchisesRepository;
import com.prueba.accenture.repositories.SubsidiariesRepository;
import com.prueba.accenture.services.ISubsidiariesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubsidiariesServices implements ISubsidiariesService {
    private SubsidiariesRepository subsidiariesRepository;
    private FranchisesRepository franchisesRepository;

    public SubsidiariesServices(SubsidiariesRepository subsidiariesRepository, FranchisesRepository franchisesRepository) {
        this.subsidiariesRepository = subsidiariesRepository;
        this.franchisesRepository = franchisesRepository;
    }

    @Override
    public void saveSubsidiary(SubsidiariesDto subsidiariesDto) {
        Subsidiaries subsidiary = new Subsidiaries();
        subsidiary.setId(subsidiariesDto.getId());
        subsidiary.setName(subsidiariesDto.getName());
        Franchises franchise = franchisesRepository.findById(subsidiariesDto.getFranchise_id()).get();
        subsidiary.setFranchise(franchise);
        subsidiariesRepository.save(subsidiary);
    }

    @Override
    public void deleteSubsidiary(int id) {
        subsidiariesRepository.deleteById(id);
    }

    @Override
    public void updateSubsidiary(SubsidiariesDto subsidiariesDto) {
        Subsidiaries subsidiary = subsidiariesRepository.findById(subsidiariesDto.getId())
                .orElseThrow(() -> new RuntimeException("Subsidiary not found"));
        subsidiary.setName(subsidiariesDto.getName());
        subsidiariesRepository.save(subsidiary);
    }

    @Override
    public List<SubsidiariesDto> getAllSubsidiaries() {
        return subsidiariesRepository.findAll().stream()
                .map(subsidiary -> {
                    FranchisesDto franchiseDto = FranchisesDto.builder()
                            .id(subsidiary.getFranchise().getId())
                            .name(subsidiary.getFranchise().getName())
                            .build();
                    return SubsidiariesDto.builder()
                            .id(subsidiary.getId())
                            .name(subsidiary.getName())
                            .franchise(franchiseDto)
                            .build();
                })
                .collect(Collectors.toList());
    }

    @Override
    public SubsidiariesDto getSubsidiaryById(int id) {
        Subsidiaries subsidiary = subsidiariesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subsidiary not found"));
        FranchisesDto franchiseDto = FranchisesDto.builder()
                .id(subsidiary.getFranchise().getId())
                .name(subsidiary.getFranchise().getName())
                .build();

        return SubsidiariesDto.builder()
                .id(subsidiary.getId())
                .name(subsidiary.getName())
                .franchise(franchiseDto)
                .build();
    }
}

package com.prueba.accenture.services.impl;

import com.prueba.accenture.dto.FranchisesDto;
import com.prueba.accenture.models.Franchises;
import com.prueba.accenture.repositories.FranchisesRepository;
import com.prueba.accenture.services.IFranchisesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FranchisesServices implements IFranchisesService {

    private FranchisesRepository franchisesRepository;

    public FranchisesServices(FranchisesRepository franchisesRepository) {
        this.franchisesRepository = franchisesRepository;
    }


    @Override
    public Franchises saveFranchise(FranchisesDto franchisesDto) {
        Franchises franchise = new Franchises();
        franchise.setId(franchisesDto.getId());
        franchise.setName(franchisesDto.getName());
        return franchisesRepository.save(franchise);
    }

    @Override
    public void deleteFranchise(int id) {
        franchisesRepository.deleteById(id);
    }

    @Override
    public void updateFranchise(FranchisesDto franchisesDto) {
        Franchises franchise = franchisesRepository.findById(franchisesDto.getId())
                .orElseThrow(() -> new RuntimeException("Franchise not found"));
        franchise.setName(franchisesDto.getName());
        franchisesRepository.save(franchise);
    }

    @Override
    public List<FranchisesDto> getAllFranchises() {
        return franchisesRepository.findAll().stream()
                .map(franchise -> {
                    return FranchisesDto.builder()
                            .id(franchise.getId())
                            .name(franchise.getName())
                            .build();
                })
                .collect(Collectors.toList());
    }

    @Override
    public FranchisesDto getFranchiseById(int id) {
        Franchises franchise = franchisesRepository.findById(id).orElseThrow();
        return FranchisesDto.builder()
                .id(franchise.getId())
                .name(franchise.getName())
                .build();
    }
}

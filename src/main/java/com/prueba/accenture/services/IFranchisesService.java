package com.prueba.accenture.services;

import com.prueba.accenture.dto.FranchisesDto;
import com.prueba.accenture.models.Franchises;

import java.util.List;
import java.util.Optional;

public interface IFranchisesService {
    public Franchises saveFranchise(FranchisesDto franchisesDto);
    public void deleteFranchise(int id);
    public void updateFranchise(FranchisesDto franchisesDto);
    public List<FranchisesDto> getAllFranchises();
    public FranchisesDto getFranchiseById(int id);

}

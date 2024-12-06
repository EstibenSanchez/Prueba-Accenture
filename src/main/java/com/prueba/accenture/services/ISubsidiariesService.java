package com.prueba.accenture.services;

import com.prueba.accenture.dto.SubsidiariesDto;
import com.prueba.accenture.models.Subsidiaries;

import java.util.List;

public interface ISubsidiariesService {
    void saveSubsidiary(SubsidiariesDto subsidiaryDto);
    List<SubsidiariesDto> getAllSubsidiaries();
    SubsidiariesDto getSubsidiaryById(int id);
    void deleteSubsidiary(int id);
    void updateSubsidiary(SubsidiariesDto subsidiaryDto);
}

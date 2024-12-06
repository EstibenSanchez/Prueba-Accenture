package com.prueba.accenture.dto;

import com.prueba.accenture.models.Franchises;
import com.prueba.accenture.models.Products;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
public class SubsidiariesDto {
    private int id;
    private String name;
    private FranchisesDto franchise;
    private int franchise_id;
}

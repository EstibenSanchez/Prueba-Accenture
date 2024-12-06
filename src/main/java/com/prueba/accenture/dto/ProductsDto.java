package com.prueba.accenture.dto;

import com.prueba.accenture.models.Subsidiaries;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProductsDto {
    private int id;
    private String name;
    private int stock;
    private SubsidiariesDto subsidiary;
    private int subsidiary_id;
}

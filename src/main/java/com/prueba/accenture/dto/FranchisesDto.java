package com.prueba.accenture.dto;

import com.prueba.accenture.models.Subsidiaries;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class FranchisesDto {
    private int id;
    private String name;
}

package com.example.castells_casteller.DTOs;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiadaFeignDTO {
    private Long id;
    private String name;
    private LocalDate diadaDate;
    private Long capId;
}

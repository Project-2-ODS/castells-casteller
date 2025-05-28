package com.example.castells_casteller.feigns;

import com.example.castells_casteller.DTOs.DiadaFeignDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "castells-diada")
public interface DiadaFeignClient {
    @GetMapping("/api/diada/{id}")
    DiadaFeignDTO getDiadaById(@PathVariable Long id);
}

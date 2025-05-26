package com.example.castells_casteller.servicies;

import com.example.castells_casteller.models.Casteller;
import com.example.castells_casteller.services.CastellerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CastellerServiceTest {
    @Autowired
    CastellerService castellerService;

    @Test
    @DisplayName("Casteller 1 encontrado")
    public void getCastellerById(){
        Casteller foundCasteller = castellerService.findCastellerById(1L);
        assertNotNull(foundCasteller);
    }
}

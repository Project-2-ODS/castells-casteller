package com.example.castells_casteller.servicies;

import com.example.castells_casteller.DTOs.CastellerDTO;
import com.example.castells_casteller.models.Casteller;
import com.example.castells_casteller.repositories.CastellerRepository;
import com.example.castells_casteller.services.CastellerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CastellerServiceTest {
    @Autowired
    CastellerService castellerService;
    @Autowired
    CastellerRepository castellerRepository;

    private Casteller casteller;

    @BeforeEach
    public void SetUp(){
        casteller = new Casteller();
        casteller.setName("Test Testing");
        casteller.setEmail("test@testing.eu");
        casteller.setDiadaId(1L);
        System.out.println("USUARIO DEL TEST: " +casteller);
        castellerService.createCasteller(casteller);
    }
    @AfterEach
    public void tearDown() {
        castellerRepository.delete(casteller);
        }




    @Test
    @DisplayName("Crear Casteller")
    public void createCasteller(){
        assertNotNull(casteller.getId(), "El Casteller deberia ser null por que no pasa por BBDD");
        assertEquals("Test Testing", casteller.getName(), "Nombre correcto");
        assertEquals("test@testing.eu", casteller.getEmail(), "Email Correcto");
        assertEquals(1L, casteller.getDiadaId(), "Diada Correcta");

    }

    @Test
    @DisplayName("Buscar Casteller por ID")
    public void findById(){
        Casteller foundCasteller = castellerService.findCastellerById(casteller.getId());
        assertNotNull(foundCasteller);
        assertEquals(casteller.getName(), foundCasteller.getName());
        assertEquals(casteller.getEmail(), foundCasteller.getEmail());
        assertEquals(casteller.getDiadaId(), foundCasteller.getDiadaId());
        System.out.println("USUARIO A COMPARAR: " +foundCasteller);
    }

    @Test
    @DisplayName("Actualizar email de Casteller")
    public void updateCastellerEmail(){
        CastellerDTO updateCasteller = new CastellerDTO();
        updateCasteller.setEmail("nuevo@nuevo.es");
        Casteller updatedCasteller = castellerService.updateCastellerEmailOrDiadaId(casteller.getId(), updateCasteller);
        assertNotNull(updatedCasteller);
        assertEquals("nuevo@nuevo.es", updatedCasteller.getEmail());
        System.out.println("USUARIO A COMPARAR: " +updatedCasteller);
    }

    @Test
    @DisplayName("Eliminar Casteller")
    public void deleteCasteller(){
        castellerService.deleteCasteller(casteller.getId());
        assertFalse(castellerRepository.existsById(casteller.getId()), "Deberia estar eliminado de la BBDD");
        System.out.println("USUARIO A COMPARAR: " + casteller);
    }
}

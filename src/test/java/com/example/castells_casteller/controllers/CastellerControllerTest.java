package com.example.castells_casteller.controllers;

import com.example.castells_casteller.models.Casteller;
import com.example.castells_casteller.repositories.CastellerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest

public class CastellerControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    CastellerRepository castellerRepository;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();


    private Casteller casteller;

    @BeforeEach
    public void SetUp(){
        casteller = new Casteller();
        casteller.setName("Test with MockMVC");
        casteller.setEmail("test@testing.eu");
        casteller.setDiadaId(1L);
        System.out.println("USUARIO DEL TEST: " +casteller);
        castellerRepository.save(casteller);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @AfterEach
    public void tearDown(){
        Casteller casteller = castellerRepository.findByName("Test with MockMVC");
        if (casteller!=null){
            castellerRepository.delete(casteller);
        }

    }

    @Test
    public void createCasteller() throws Exception {
        String castellerJSON = objectMapper.writeValueAsString(casteller);

        MvcResult result = mockMvc.perform(post("/api/casteller")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(castellerJSON)
        ).andExpect(status().isCreated()).andReturn();
        String stringResponse = result.getResponse().getContentAsString();
        assertTrue(stringResponse.contains("Test with MockMVC"));

    }

    @Test
    public void updateCasteller() throws Exception{
        String castellerJSON = objectMapper.writeValueAsString(casteller);

        MvcResult result = mockMvc.perform(put("/api/casteller/"+casteller.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(castellerJSON)
        ).andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Test with MockMVC"));
    }

    @Test
    public void deleteCasteller() throws Exception {
        String castellerJSON = objectMapper.writeValueAsString(casteller);

        MvcResult result = mockMvc.perform(delete("/api/casteller/"+casteller.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(castellerJSON)
        ).andExpect(status().isNoContent()).andReturn();
        assertFalse(result.getResponse().getContentAsString().contains("Test with MockMVC"));

    }
}

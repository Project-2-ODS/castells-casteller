package com.example.castells_casteller.controllers;

import com.example.castells_casteller.DTOs.CastellerDTO;
import com.example.castells_casteller.expeptions.CastellerNotFoundException;
import com.example.castells_casteller.models.Casteller;
import com.example.castells_casteller.services.CastellerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/casteller")
public class CastellerController {
    @Autowired
    CastellerService castellerService;

    //CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Casteller createCasteller(@RequestBody @Valid Casteller casteller){ //Cambiar a RequestDTO y contestar con ResponseDTO
        return castellerService.createCasteller(casteller);
    }

    //READ
    @GetMapping("/{id}")
   public ResponseEntity<?> getCastellerById(@PathVariable Long id){

       try{
           Casteller foundCasteller = castellerService.findCastellerById(id);
           return new ResponseEntity<>(foundCasteller, HttpStatus.OK);
       }catch (CastellerNotFoundException exception){
           return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
       }


    }

    //UPDATE
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateCastellerEmailOrDiadaId(@PathVariable Long id, CastellerDTO castellerDTO){

        try {
            Casteller existingCasteller = castellerService.updateCastellerEmailOrDiadaId(id, castellerDTO);
            return ResponseEntity.ok(existingCasteller);
        }catch (CastellerNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(exception.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCastellerAllInfo(@PathVariable Long id, @RequestBody Casteller casteller){
        try {
            Casteller existingCasteller = castellerService.updateCastellerAllInfo(id, casteller);
            return ResponseEntity.ok(existingCasteller);
        }catch (CastellerNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(exception.getMessage());
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCasteller(@PathVariable Long id){
        try {
            Casteller existingCasteller = castellerService.deleteCasteller(id);
            return ResponseEntity.noContent().build();//TODO: en el body poner "Casteller eliminado"
        }catch (CastellerNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(exception.getMessage());
        }
    }
}

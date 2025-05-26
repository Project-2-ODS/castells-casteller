package com.example.castells_casteller.controllers;

import com.example.castells_casteller.expeptions.CastellerNotFountException;
import com.example.castells_casteller.models.Casteller;
import com.example.castells_casteller.services.CastellerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/casteller/")
public class CastellerController {
    @Autowired
    CastellerService castellerService;

    //CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Casteller createCasteller(@RequestBody @Valid Casteller casteller){
        return castellerService.createCasteller(casteller);
    }

    //READ
    @GetMapping("{id}")
   public ResponseEntity<?> getCastellerById(@PathVariable Long id){

       try{
           Casteller foundCasteller = castellerService.findCastellerById(id);
           return new ResponseEntity<>(foundCasteller, HttpStatus.OK);
       }catch (CastellerNotFountException exception){
           return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
       }


    }

}

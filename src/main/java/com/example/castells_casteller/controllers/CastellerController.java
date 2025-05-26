package com.example.castells_casteller.controllers;

import com.example.castells_casteller.expeptions.CastellerNotFountException;
import com.example.castells_casteller.models.Casteller;
import com.example.castells_casteller.services.CastellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/casteller")
public class CastellerController {
    @Autowired
    CastellerService castellerService;

    //GET
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

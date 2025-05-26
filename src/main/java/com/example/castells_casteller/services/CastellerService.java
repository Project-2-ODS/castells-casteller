package com.example.castells_casteller.services;

import com.example.castells_casteller.expeptions.CastellerNotFountException;
import com.example.castells_casteller.models.Casteller;
import com.example.castells_casteller.repositories.CastellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Service
public class CastellerService {
    @Autowired
    CastellerRepository castellerRepository;

   public Casteller findCastellerById(Long id){
        Optional<Casteller> foundCasteller = castellerRepository.findById(id);
        if (foundCasteller.isPresent()){
            return foundCasteller.get();
        }else{
            throw new CastellerNotFountException("Casteller no encontrado");
        }
    }

    public Casteller createCasteller(Casteller casteller){
        return castellerRepository.save(casteller);
    }

}

package com.example.castells_casteller.services;

import com.example.castells_casteller.DTOs.CastellerDTO;
import com.example.castells_casteller.expeptions.CastellerNotFoundException;

import com.example.castells_casteller.models.Casteller;
import com.example.castells_casteller.repositories.CastellerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CastellerService {
    @Autowired
    CastellerRepository castellerRepository;
    //CREATE

    public Casteller createCasteller(Casteller casteller){
        return castellerRepository.save(casteller);
    }

    //READ
   public Casteller findCastellerById(Long id){
        Optional<Casteller> foundCasteller = castellerRepository.findById(id);
        if (foundCasteller.isPresent()){
            return foundCasteller.get();
        }else{
            throw new CastellerNotFoundException("Casteller no encontrado");
        }
    }

    //UPDATE
    public Casteller updateCastellerEmailOrDiadaId(Long id, CastellerDTO castellerDTO){
        Casteller existingCasteller = castellerRepository.findById(id).orElseThrow(()->new CastellerNotFoundException("Casteller con id " +id+" no encontrado"));
        if(castellerDTO.getEmail()!= null){
            existingCasteller.setEmail(castellerDTO.getEmail());
        }
        if(castellerDTO.getDiadaId()!= null){
            existingCasteller.setDiadaId(castellerDTO.getDiadaId());
        }
        return castellerRepository.save(existingCasteller);
    }
    public Casteller updateCastellerAllInfo(Long id, Casteller casteller){
        Casteller existingCasteller = castellerRepository.findById(id).orElseThrow(()->new CastellerNotFoundException("Casteller con id " +id+" no encontrado"));
        existingCasteller.setName(casteller.getName());
        existingCasteller.setEmail(casteller.getEmail());
        existingCasteller.setDiadaId(casteller.getDiadaId());
        return castellerRepository.save(existingCasteller);
    }
    public Casteller deleteCasteller(Long id){

        Casteller existingCasteller = castellerRepository.findById(id).orElseThrow(()->new CastellerNotFoundException("Casteller con id " +id+" no encontrado"));
        castellerRepository.delete(existingCasteller);
        return existingCasteller;
    }

}

package com.example.castells_casteller.repositories;


import com.example.castells_casteller.models.Casteller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastellerRepository extends JpaRepository<Casteller, Long> {
}

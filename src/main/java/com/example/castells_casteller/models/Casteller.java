package com.example.castells_casteller.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Casteller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 1, max = 255, message = "No puede superar los 255 caracteres")
    @NotBlank(message = "El nombre no puede estar vacio, tener solo espacios o ser nulo")
    private String name;
    @Email(message = "Debe cumplir con el formato de email: example@example.com")
    @NotNull(message = "Debe incluir un email")
    private String email;
    private Long diadaId;

    public Casteller(String name, String email, Long diadaId) {
        this.name = name;
        this.email = email;
        this.diadaId = diadaId;
    }
}


package com.example.castells_casteller.expeptions;

public class CastellerNotFoundException extends RuntimeException {
    public CastellerNotFoundException(String message) {
        super(message);
    }
}

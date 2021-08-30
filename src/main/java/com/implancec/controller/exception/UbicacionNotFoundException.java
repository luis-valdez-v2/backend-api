package com.implancec.controller.exception;

public class UbicacionNotFoundException extends RuntimeException {
    public UbicacionNotFoundException(Long id) {
        super("Could not find ubicacion " + id);
    }
}

package com.implancec.controller.exception;

public class ServicioNotFoundException extends RuntimeException{
    public ServicioNotFoundException(Long id) {
        super("Could not find Servicio " + id);
    }
}

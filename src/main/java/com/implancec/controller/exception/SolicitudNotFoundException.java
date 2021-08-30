package com.implancec.controller.exception;

public class SolicitudNotFoundException extends RuntimeException{
    public SolicitudNotFoundException(Long folio) {
        super("Could not find solicitud " + folio);
    }
}

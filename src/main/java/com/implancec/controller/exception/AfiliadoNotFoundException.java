package com.implancec.controller.exception;

public class AfiliadoNotFoundException extends RuntimeException {
    public AfiliadoNotFoundException(Long id) {
        super("Could not find afiliado " + id);
    }
}

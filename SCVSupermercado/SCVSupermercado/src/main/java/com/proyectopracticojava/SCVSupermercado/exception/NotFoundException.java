package com.proyectopracticojava.SCVSupermercado.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String mensaje) {
        super(mensaje);
    }
}

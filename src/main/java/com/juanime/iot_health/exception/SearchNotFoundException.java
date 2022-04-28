package com.juanime.iot_health.exception;

public class SearchNotFoundException extends RuntimeException {
    public SearchNotFoundException() {
        super("Recurso não encontrado");
    }

    public SearchNotFoundException(String resourceName, Long id) {
        super(String.format("%s com identificador: %d não encontrado(a)", resourceName, id));
    }
}

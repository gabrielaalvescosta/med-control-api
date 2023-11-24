package com.medcontrol.medcontrol.exception;

public class MedicamentoNotFoundException extends RuntimeException {

    public MedicamentoNotFoundException(String message) {
        super(message);
    }
}

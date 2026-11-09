package com.boulhosa.agendadortarefas.infrastructure.exeptions;

public class ResourceNotFoundExeption extends RuntimeException{
    public ResourceNotFoundExeption(String message) {
        super(message);
    }

    public ResourceNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }
}

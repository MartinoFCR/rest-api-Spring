package com.ecommerce.api_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private Object fieldvalue;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldvalue) {
        super(String.format("%s no fue encontrado con %s='%s'", resourceName, fieldName, fieldvalue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldvalue = fieldvalue;
    }

    public ResourceNotFoundException(String resourceName) {
        super(String.format("No se encontraron registros de %s en el sistema", resourceName));
        this.resourceName = resourceName;
    }
}

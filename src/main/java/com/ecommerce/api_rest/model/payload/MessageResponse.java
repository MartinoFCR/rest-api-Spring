package com.ecommerce.api_rest.model.payload;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Data
@ToString
@Builder
public class MessageResponse implements Serializable {
    private String message;
    private Object object;

}

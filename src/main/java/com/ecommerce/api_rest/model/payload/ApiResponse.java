package com.ecommerce.api_rest.model.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor

public class ApiResponse {

    private Date timestamp  = new Date();
    private String message;
    private String url;

    public ApiResponse(String message, String url) {
        this.message = message;
        this.url = url.replace("uri=","");
    }
}

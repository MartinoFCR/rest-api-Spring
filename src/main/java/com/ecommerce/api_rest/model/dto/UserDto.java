package com.ecommerce.api_rest.model.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;


@Data
@ToString
@Builder
public class UserDto implements Serializable {


    private UUID id_user;
    private String name_user;
    private String password_user;
    private String mail_user;
    private String phone_user;
    private String address_user;
    private UUID profile_user;


}

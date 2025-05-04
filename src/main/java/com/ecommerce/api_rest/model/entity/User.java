package com.ecommerce.api_rest.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_user;
    @Column(name = "name_user")
    private String name_user;
    @Column(name = "password_user")
    private String password_user;
    @Column(name = "mail_user")
    private String mail_user;
    @Column(name = "phone_user")
    private String phone_user;
    @Column(name = "address_user")
    private String address_user;
    @Column(name = "profile_user")
    private UUID profile_user;


}

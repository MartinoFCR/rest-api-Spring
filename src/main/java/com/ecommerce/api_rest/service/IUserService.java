package com.ecommerce.api_rest.service;

import com.ecommerce.api_rest.model.dto.UserDto;
import com.ecommerce.api_rest.model.entity.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {

    List<User> listAllUsers();

    User save(UserDto user);

    User findById(UUID id);

    void delete(User user);

    boolean existsById(UUID id);

}

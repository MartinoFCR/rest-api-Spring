package com.ecommerce.api_rest.model.dao;

import com.ecommerce.api_rest.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface UserDao extends CrudRepository<User, UUID> {
}

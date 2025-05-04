package com.ecommerce.api_rest.service.impl;

import com.ecommerce.api_rest.model.dao.UserDao;
import com.ecommerce.api_rest.model.dto.UserDto;
import com.ecommerce.api_rest.model.entity.User;
import com.ecommerce.api_rest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listAllUsers() {
        return (List) userDao.findAll();
    }

    @Transactional
    @Override
    public User save(UserDto userDto) {
        User user = User.builder()
                .id_user(userDto.getId_user())
                .name_user(userDto.getName_user())
                .password_user(userDto.getPassword_user())
                .mail_user(userDto.getMail_user())
                .phone_user(userDto.getPhone_user())
                .address_user(userDto.getAddress_user())
                .profile_user(userDto.getProfile_user())
                .build();
        return userDao.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(UUID id) {
        return userDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public boolean existsById(UUID id) {
        return userDao.existsById(id);
    }
}

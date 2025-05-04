package com.ecommerce.api_rest.controller;


import com.ecommerce.api_rest.exception.BadRequestException;
import com.ecommerce.api_rest.exception.ResourceNotFoundException;
import com.ecommerce.api_rest.model.dto.UserDto;
import com.ecommerce.api_rest.model.entity.User;
import com.ecommerce.api_rest.model.payload.MessageResponse;
import com.ecommerce.api_rest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("users")
    public  ResponseEntity<?> showAll(){
        List<User> getList = userService.listAllUsers();

        if(getList == null || getList.isEmpty()){
            throw  new ResourceNotFoundException("Usuario");
        }

        return new ResponseEntity<>(MessageResponse.builder()
                .message("")
                .object(getList)
                .build()
                , HttpStatus.OK);
    }

    @PostMapping("user")
    public ResponseEntity<?> create(@RequestBody UserDto userDto){
        User userSave = null;
        try {
            userSave = userService.save(userDto);
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Guardado correctamente")
                    .object(UserDto.builder()
                            .id_user(userSave.getId_user())
                            .name_user(userSave.getName_user())
                            .password_user(userSave.getPassword_user())
                            .mail_user(userSave.getMail_user())
                            .phone_user(userSave.getPhone_user())
                            .address_user(userSave.getAddress_user())
                            .profile_user(userSave.getProfile_user())
                            .build())
                    .build()
                    , HttpStatus.CREATED);
        }catch (DataAccessException exDt) {
            throw new BadRequestException(exDt.getMessage());
        }
    }

    @PutMapping("user/{id}")
    public ResponseEntity<?> update(@RequestBody UserDto userDto, @PathVariable UUID id) {
        User userUpdate = null;
        try {
            if(userService.existsById(id)){
                userDto.setId_user(id);
                userUpdate = userService.save(userDto);

                return new ResponseEntity<>(MessageResponse.builder()
                        .message("Guardado correctamente")
                        .object(UserDto.builder()
                                .id_user(userUpdate.getId_user())
                                .name_user(userUpdate.getName_user())
                                .password_user(userUpdate.getPassword_user())
                                .mail_user(userUpdate.getMail_user())
                                .phone_user(userUpdate.getPhone_user())
                                .address_user(userUpdate.getAddress_user())
                                .profile_user(userUpdate.getProfile_user())
                                .build())
                        .build()
                        , HttpStatus.CREATED);
            }else {
                throw new ResourceNotFoundException("Usuario","id",id);
            }
        }catch (DataAccessException exDt) {
            throw new BadRequestException(exDt.getMessage());
        }
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        try {
            User userDelete = userService.findById(id);
            userService.delete(userDelete);
            return new ResponseEntity<>(userDelete, HttpStatus.NO_CONTENT);
        }catch (DataAccessException exDt) {
            throw new BadRequestException(exDt.getMessage());
        }
    }

    @GetMapping("user/{id}")
    public  ResponseEntity<?> showById(@PathVariable UUID id){
        User user = userService.findById(id);

        if(user == null){
            throw  new ResourceNotFoundException("Usuario","id",id);
        }

        return new ResponseEntity<>(MessageResponse.builder()
                .message("")
                .object(UserDto.builder()
                        .id_user(user.getId_user())
                        .name_user(user.getName_user())
                        .password_user(user.getPassword_user())
                        .mail_user(user.getMail_user())
                        .phone_user(user.getPhone_user())
                        .address_user(user.getAddress_user())
                        .profile_user(user.getProfile_user())
                        .build())
                .build()
                , HttpStatus.OK);
    }
}

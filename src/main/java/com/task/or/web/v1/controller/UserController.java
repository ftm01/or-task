package com.task.or.web.v1.controller;

import com.task.or.criteria.UserParams;
import com.task.or.domain.User;
import com.task.or.mapper.UserMapper;
import com.task.or.services.UserService;
import com.task.or.web.v1.dtos.ResponseWrapper;
import com.task.or.web.v1.dtos.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseWrapper<Collection<UserDTO>>> getAllUsers() {
        Collection<User> users = userService.getAllUsers();
        Collection<UserDTO> userDTOs = userMapper.toUserDTOs(users);
        return ResponseEntity.ok(new ResponseWrapper<>(userDTOs, HttpStatus.OK.value()));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseWrapper<UserDTO>> getUser(UserParams userParams) {
        User user = userService.getUser(userParams);
        UserDTO userDTO = userMapper.toUserDTOWithGender(user);
        return ResponseEntity.ok(new ResponseWrapper<>(userDTO, HttpStatus.OK.value()));
    }
}

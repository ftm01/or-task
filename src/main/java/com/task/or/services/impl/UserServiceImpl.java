package com.task.or.services.impl;

import com.task.or.domain.User;
import com.task.or.exception.user.UserNotFoundException;
import com.task.or.repository.UserRepository;
import com.task.or.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User could not be found."));
    }

}

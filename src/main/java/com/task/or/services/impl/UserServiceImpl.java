package com.task.or.services.impl;

import com.task.or.criteria.UserParams;
import com.task.or.domain.User;
import com.task.or.exception.params.MissingRequestParameterException;
import com.task.or.exception.password.WrongPasswordException;
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

    @Override
    public User getUser(UserParams userParams) {
        if(!userParams.isIdSpecified() && !userParams.isPasswordSpecified()) {
            throw new MissingRequestParameterException("Parameters 'id' and 'password' are missing.");
        }
        if(!userParams.isIdSpecified()) {
            throw new MissingRequestParameterException("Parameter 'id' is missing.");
        }
        if(!userParams.isPasswordSpecified()) {
            throw new MissingRequestParameterException("Parameter 'password' is missing.");
        }

        User user = userRepository.findById(userParams.getId()).orElseThrow(() -> new UserNotFoundException("User could not be found."));
        if(!user.getPassword().equals(userParams.getPassword())) {
            throw new WrongPasswordException("Wrong password.");
        }

        return user;
    }
}

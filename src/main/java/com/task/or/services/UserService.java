package com.task.or.services;

import com.task.or.domain.User;

import java.util.Collection;

public interface UserService {

    Collection<User> getAllUsers();

    User getUser(Integer userId);
}

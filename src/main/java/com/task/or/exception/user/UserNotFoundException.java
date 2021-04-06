package com.task.or.exception.user;

import com.task.or.exception.general.ResourceNotFoundException;

public class UserNotFoundException extends ResourceNotFoundException {
    public UserNotFoundException(String msg) {
        super(msg);
    }
}

package com.task.or.exception.password;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class WrongPasswordException extends RuntimeException {

    private final String name = HttpStatus.UNAUTHORIZED.getReasonPhrase();
    private final HttpStatus status = HttpStatus.UNAUTHORIZED;

    public WrongPasswordException(String msg) {
        super(msg);
    }

    public String getName() {
        return this.name;
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}

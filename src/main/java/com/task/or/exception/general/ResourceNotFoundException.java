package com.task.or.exception.general;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private final String name = HttpStatus.NOT_FOUND.getReasonPhrase();
    private final HttpStatus status = HttpStatus.NOT_FOUND;

    public ResourceNotFoundException(String msg) {
        super(msg);
    }

    public String getName() {
        return this.name;
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}

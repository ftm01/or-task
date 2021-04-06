package com.task.or.exception.params;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class RequestParameterException extends RuntimeException {

    private final String name = HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase();
    private final HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

    public RequestParameterException(String msg) {
        super(msg);
    }

    public String getName() {
        return this.name;
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}

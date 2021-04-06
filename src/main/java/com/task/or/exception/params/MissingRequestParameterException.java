package com.task.or.exception.params;

public class MissingRequestParameterException extends RequestParameterException {

    public MissingRequestParameterException(String msg) {
        super(msg);
    }
}

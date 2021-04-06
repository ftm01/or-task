package com.task.or.exception;

import com.task.or.exception.general.ResourceNotFoundException;
import com.task.or.exception.params.RequestParameterException;
import com.task.or.exception.password.WrongPasswordException;
import com.task.or.web.v1.dtos.ErrorWrapper;
import com.task.or.web.v1.dtos.ResponseWrapper;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex) {
        ErrorWrapper error = new ErrorWrapper(ex.getName(), ex.getMessage());
        return buildResponse(error, ex.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleRequestParameter(RequestParameterException ex) {
        ErrorWrapper error = new ErrorWrapper(ex.getName(), ex.getMessage());
        return buildResponse(error, ex.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleWrongPassword(WrongPasswordException ex) {
        ErrorWrapper error = new ErrorWrapper(ex.getName(), ex.getMessage());
        return buildResponse(error, ex.getStatus());
    }

    private ResponseEntity<Object> buildResponse(ErrorWrapper error, HttpStatus httpStatus) {
        ResponseWrapper<ErrorWrapper> errorWrapper = new ResponseWrapper<>(error, httpStatus.value());
        return new ResponseEntity<>(errorWrapper, httpStatus);
    }
}

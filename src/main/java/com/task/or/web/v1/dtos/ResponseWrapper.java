package com.task.or.web.v1.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseWrapper<T> {

    private T data;
    private ErrorWrapper error;
    private Boolean success = true;
    private int status;

    public ResponseWrapper(int status) {
        this.status = status;
    }

    public ResponseWrapper(Boolean success, int status) {
        this.success = success;
        this.status = status;
    }

    public ResponseWrapper(T data, int status) {
        this.data = data;
        this.status = status;
    }

    public ResponseWrapper(T data, Boolean success, int status) {
        this.data = data;
        this.success = success;
        this.status = status;
    }

//    public ResponseWrapper(T data, PaginationWrapper pagination, int status) {
//        this.data = data;
//        this.pagination = pagination;
//        this.status = status;
//        this.success = setSuccess(status);
//    }

    public ResponseWrapper(ErrorWrapper error, int status) {
        this.error = error;
        this.status = status;
        this.success = setSuccess(status);
    }

    private boolean setSuccess(int status) {
        return status >= 200 && status < 300;
    }
}

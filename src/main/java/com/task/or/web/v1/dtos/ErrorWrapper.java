package com.task.or.web.v1.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.task.or.web.v1.dtos.user.ErrorDetail;
import lombok.*;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorWrapper {

    private String name;
    private String message;
    private Object target;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp = LocalDateTime.now();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ErrorDetail> details = new ArrayList<>();

    private String debugId;
    private String path;

    public ErrorWrapper(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public ErrorWrapper(String name, String message, Object target) {
        this.name = name;
        this.message = message;
        this.target = target;
    }

    public ErrorWrapper(String name, String message, Object target, List<ErrorDetail> details) {
        this.name = name;
        this.message = message;
        this.target = target;
        this.details = details;
    }

    public void addErrorDetails(List<FieldError> fieldErrors) {
        fieldErrors.forEach(this::addErrorDetail);
    }

    public void addErrorDetail(FieldError fieldError) {
        this.details.add(new ErrorDetail(fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage()));
    }
}

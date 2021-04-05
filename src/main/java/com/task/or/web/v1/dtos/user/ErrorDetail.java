package com.task.or.web.v1.dtos.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetail {

    private String field;
    private Object value;
    private String issue;
    private String location;

    public ErrorDetail(String field, Object value, String issue) {
        this.field = field;
        this.value = value instanceof MultipartFile ? ((MultipartFile)value).getOriginalFilename() : value;
        this.issue = issue;
    }
}

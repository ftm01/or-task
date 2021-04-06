package com.task.or.criteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserParams {

    private Integer id;
    private String password;

    public boolean areParamsSpecified() {
        return Objects.nonNull(id) && Objects.nonNull(password);
    }

    public boolean isIdSpecified() {
        return Objects.nonNull(id);
    }

    public boolean isPasswordSpecified() {
        return Objects.nonNull(password);
    }
}

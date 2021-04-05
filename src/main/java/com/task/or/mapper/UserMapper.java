package com.task.or.mapper;

import com.task.or.domain.User;
import com.task.or.web.v1.dtos.user.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public Collection<UserDTO> toUserDTOs(Collection<User> users) {
        return users.stream().map(this::toUserDTO).collect(Collectors.toList());
    }

    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }
}

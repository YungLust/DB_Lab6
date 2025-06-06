package com.example.DB_Lab6.mapper;

import com.example.DB_Lab6.dto.UserDto;
import com.example.DB_Lab6.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getPassword(),
                user.getLastName(),
                user.getEmail(),
                user.getLogin()
        );
    }

    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.id());
        user.setFirstName(userDto.firstName());
        user.setPassword(userDto.password());
        user.setLastName(userDto.lastName());
        user.setEmail(userDto.email());
        user.setLogin(userDto.login());
        return user;
    }
}
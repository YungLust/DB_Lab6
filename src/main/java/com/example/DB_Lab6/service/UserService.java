package com.example.DB_Lab6.service;

import com.example.DB_Lab6.dto.UserDto;
import com.example.DB_Lab6.entity.User;
import com.example.DB_Lab6.exception.ResourceNotFoundException;
import com.example.DB_Lab6.mapper.UserMapper;
import com.example.DB_Lab6.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);

    }

    public UserDto getUserById(Long id) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id:" + id));
        return userMapper.toDto(foundUser);
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id:" + id));
        user.setFirstName(userDto.firstName());
        user.setPassword(userDto.password());
        user.setLastName(userDto.lastName());
        user.setEmail(userDto.email());
        user.setLogin(userDto.login());
        User updatedUser = userRepository.save(user);
        return userMapper.toDto(updatedUser);
    }

    public void deleteUser(Long id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
        else{
            throw new ResourceNotFoundException("User not found with id:" + id);
        }
    }
}

package com.example.DB_Lab6.dto;

public record UserDto (
    Long id,
    String firstName,
    String password,
    String lastName,
    String email,
    String login) {}

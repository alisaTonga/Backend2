package de.ait.users.app.service;

import de.ait.users.app.DTO.UserRequestDTO;
import de.ait.users.app.DTO.UserResponseDto;
import de.ait.users.app.entity.User;

import java.util.List;

public interface UserServiceInt {
    //List<User> findAll();
    UserResponseDto createNewUser(UserRequestDTO user);
    UserResponseDto findById(Long id);
    //List<User> findByName(String name);
    List<UserResponseDto> getUsers(String name, String email);
    UserResponseDto updateUser(Long id, UserRequestDTO user);

}

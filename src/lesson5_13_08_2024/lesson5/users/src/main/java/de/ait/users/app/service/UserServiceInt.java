package de.ait.users.app.service;

import de.ait.users.app.entity.User;

import java.util.List;

public interface UserServiceInt {
    //List<User> findAll();
    User createNewUser(User user);
    User findById(Long id);
    //List<User> findByName(String name);
    List<User> getUsers(String name, String email);

}

package de.ait.users.service;

import de.ait.users.entity.User;

import java.util.List;

public interface UserServiceInt {
    List<User> findAll();
    User createNewUser(User user);
    User findById(Long id);
    List<User> findByName(String name);

}

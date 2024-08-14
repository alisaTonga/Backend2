package de.ait.users.app.repository;

import de.ait.users.app.entity.User;

import java.util.List;

public interface UserRepositoryInt {
    List<User> findAll();
    User save(User user);
}

package de.ait.users.app.repository;

import de.ait.users.app.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements UserRepositoryInt {
    private List<User> database = new ArrayList<>(List.of(
            new User(1L, "Jack", "jack@mail.com", "qwert1"),
            new User(2L, "Ann", "ann@mail.com", "qkjda"),
            new User(3L, "Jack", "jack1977@mail.com", "qwhhhd"),
            new User(4L, "Lena", "lena@mail.com", "qljsda")
    ));

    @Override
    public List<User> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            createUser(user);
        } else {
            return updateUser(user);
        }
        return user;
    }

    private User updateUser(User user) {
        Optional<User> userFromDB = findById(user.getId());
        if (userFromDB.isEmpty()) {
            return null;
        } else {
            User u = userFromDB.get();
            u.setName(user.getName());
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
        }
        return user;
    }

    private User createUser(User user) {
        // создание нового user
        Long newId = database.get(database.size() - 1).getId() + 1;
        user.setId(newId);
        database.add(user);
        return user;
    }

    private Optional<User> findById(Long id) {
        return database.stream()
                .filter(u -> u.getId().equals(id))
                .findAny();
    }
}

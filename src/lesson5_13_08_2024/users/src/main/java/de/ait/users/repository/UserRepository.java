package de.ait.users.repository;

import de.ait.users.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepository implements UserRepositoryInt{
    List<User> database = new ArrayList<>(List.of(
            new User(1L, "Jack", "jack@email.com","qwetz1"),
            new User(2L, "Ann", "ann@email.com","qkjda"),
            new User(3L, "Jack", "jack1977@email.com","qwhhhd"),
            new User(4L, "Lena", "lena@email.com","qljsda")
    ));
    @Override
    public List<User> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public User save(User user) {
        if (user.getId() ==null){
            Long newId = database.get(database.size()-1).getId() +1;
            user.setId(newId);
            database.add(user);
        }
        else {
            //TODO update user
        }
        return user;
    }
}

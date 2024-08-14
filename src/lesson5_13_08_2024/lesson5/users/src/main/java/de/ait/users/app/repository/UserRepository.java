package de.ait.users.app.repository;

import de.ait.users.app.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements UserRepositoryInt{
    private List<User> database = new ArrayList<>(List.of(
            new User(1L, "Jack", "jack@mail.com","qwert1"),
            new User(2L, "Ann", "ann@mail.com","qkjda"),
            new User(3L, "Jack", "jack1977@mail.com","qwhhhd"),
            new User(4L, "Lena", "lena@mail.com","qljsda")
    ));
    @Override
    public List<User> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public User save(User user) {
        if(user.getId()==null){
            // создание нового user
            Long newId = database.get(database.size() - 1).getId() + 1;
            user.setId(newId);
            database.add(user);
        } else {
            // изменение
            // TODO update user
        }
        return user;
    }
}

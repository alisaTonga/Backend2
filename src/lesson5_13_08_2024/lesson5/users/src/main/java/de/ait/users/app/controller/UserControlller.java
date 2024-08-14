package de.ait.users.app.controller;

import de.ait.users.app.entity.User;
import de.ait.users.app.service.UserServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserControlller {
    private final UserServiceInt service;

    @Autowired
    public UserControlller(UserServiceInt service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> getUsers(@RequestParam (name= "n", required = false, defaultValue = "") String name,
                                @RequestParam (name= "e", required = false, defaultValue = "") String email){

        return service.getUsers(name, email);
    }

    @PostMapping("/users")
    public User createNewUser(@RequestBody User user){
        return service.createNewUser(user);
    }
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(name = "id") Long id){
        return service.findById(id);
    }

}

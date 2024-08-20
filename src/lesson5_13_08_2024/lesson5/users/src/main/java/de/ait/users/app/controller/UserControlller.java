package de.ait.users.app.controller;

import de.ait.users.app.DTO.UserRequestDTO;
import de.ait.users.app.DTO.UserResponseDto;
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
    public List<UserResponseDto> getUsers(@RequestParam (name= "n", required = false, defaultValue = "") String name,
                                          @RequestParam (name= "e", required = false, defaultValue = "") String email){

        return service.getUsers(name, email);
    }


    @PostMapping("/users")
    public UserResponseDto createNewUser(@RequestBody UserRequestDTO userDto){
        return service.createNewUser(userDto);
    }

    @GetMapping("/users/{id}")
    public UserResponseDto getUserById(@PathVariable(name = "id") Long id){
        return service.findById(id);
    }

    @PutMapping("/users/{id}")
    public UserResponseDto updateUser(@PathVariable(name="id") Long id ,@RequestBody UserRequestDTO userDto){
        return service.updateUser(id, userDto);
    }

}

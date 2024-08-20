package de.ait.users.app.service;

import de.ait.users.app.DTO.UserRequestDTO;
import de.ait.users.app.DTO.UserResponseDto;
import de.ait.users.app.entity.User;
import de.ait.users.app.repository.UserRepositoryInt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class UserService implements UserServiceInt{
    private final UserRepositoryInt repository;
    private final ModelMapper mapper;
    @Autowired
    public UserService(@Qualifier("getRepository") UserRepositoryInt repository,
                       ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<UserResponseDto> findAll() {
        return UserResponseDto.of(repository.findAll());
    }

    @Override
    public UserResponseDto createNewUser(UserRequestDTO userDto) {

//        if (user.getId()!=null){
 //           user.setId(null);
      //  }
        User user = repository.save(mapper.map(userDto, User.class));
        return mapper.map(user, UserResponseDto.class);
    }

    @Override
    public UserResponseDto findById(Long id) {
        return findAll()
                .stream()
                .filter(u->u.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<UserResponseDto> getUsers(String name, String email) {

        Predicate<User> predicateByName =
                (name.equals("")) ? u->true: user -> user.getName().equalsIgnoreCase(name);

        Predicate<User> predicateByEmail =
                (email.equals("")) ? u->true: u -> u.getEmail().equalsIgnoreCase(email);

        Predicate<User> allCondition = predicateByName.and(predicateByEmail);

        List<User> userList = repository.findAll()
                .stream()
                .filter(allCondition)
                .toList();
        return UserResponseDto.of(userList);
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDTO userDto) {
        User user = UserRequestDTO.toEntity(userDto);
        user.setId(id);
        return UserResponseDto.of(repository.save(user));
    }


    public List<UserResponseDto> findByName(String name) {
        return findAll()
                .stream()
                .filter(u->u.getName().equals(name))
                .toList();
    }
}

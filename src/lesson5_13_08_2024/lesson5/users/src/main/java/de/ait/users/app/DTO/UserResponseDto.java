package de.ait.users.app.DTO;

import de.ait.users.app.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserResponseDto {
    private Long id;
    private String name;
    private String email;

    public UserResponseDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static UserResponseDto of(User user) {
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail());
    }

    public static List<UserResponseDto> of(List<User> user) {
        return user.stream()
                .map(u-> UserResponseDto.of(u))
                .collect(Collectors.toList());
    }
}

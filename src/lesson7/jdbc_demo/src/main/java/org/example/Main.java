package org.example;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        JDBC_Demo.LoadDriver();
//        List<User> allUsers = JDBC_Demo.getAllUsers();
//        System.out.println(allUsers);
//
//        User user = new User("Georg", "georg@gmail.com", "nfhlvna");
//        User createdUser = JDBC_Demo.create(user);
//        List<User> users = JDBC_Demo.getAllUsers();
//        System.out.println(users);
//
//        createdUser.setName("Vika");
//        createdUser.setEmail("vika@gmail.com");
//        System.out.println("------------UPDATE-------------");
//        JDBC_Demo.update(createdUser);
//        users = JDBC_Demo.getAllUsers();
//        System.out.println(users);
        User user4 = JDBC_Demo.findById(4L);
        System.out.println(user4);
    }
}
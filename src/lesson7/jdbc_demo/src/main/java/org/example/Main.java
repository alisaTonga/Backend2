package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        JDBC_Demo.LoadDriver();
        List<User> allUsers = JDBC_Demo.getAllUsers();
        System.out.println(allUsers);
    }
}
package org.example;

import org.example.enitity.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HibernateConfiguration hibernateConfiguration = new HibernateConfiguration();
        UserXmlHibernateConfiguration configuration = new UserXmlHibernateConfiguration(hibernateConfiguration);
        List<User> users = configuration.findAll();
        System.out.println(users);

        System.out.println("Find by id");
        User user = configuration.getByID(2L);
        System.out.println(user);

        System.out.println("add new user");
        User newUser= configuration.create(new User(null, "George" , "george@gmail.com", "bulfsgfafg"));
        System.out.println(newUser);
    }
}
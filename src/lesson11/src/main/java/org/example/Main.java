package org.example;

import org.example.enitity.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HibernateConfiguration hibernateConfiguration = new HibernateConfiguration();
        UserXmlHibernateConfiguration configuration = new UserXmlHibernateConfiguration(hibernateConfiguration);
        List<User> users = configuration.findAll();
        System.out.println(users);
    }
}
package org.example;

import jakarta.persistence.EntityManager;
import org.example.enitity.User;

import java.util.List;

public class UserXmlHibernateConfiguration {
    private final HibernateConfiguration hibernateConfiguration;
    private final EntityManager entityManager;

    public UserXmlHibernateConfiguration(HibernateConfiguration hibernateConfiguration) {
        this.hibernateConfiguration = hibernateConfiguration;
        entityManager = hibernateConfiguration.getEntityManager();
    }
    public List<User> findAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
        //manager create request from user
    }
}

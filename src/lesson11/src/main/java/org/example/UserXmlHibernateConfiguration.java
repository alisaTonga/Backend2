package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
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

    public User getByID(Long id) {
        return entityManager.find(User.class, id);
    }

    public User create(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
            return user;
        }
        catch(Exception e){
            if (transaction !=null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error creating user" + user);

        }
    }
}
package com.as.genieacs.acs.dao.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.as.genieacs.acs.entity.mysql.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UserRepository {
	
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class)
                            .getResultList();
    }
    
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    public User save(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
            return user;
        } else {
            return entityManager.merge(user);
        }
    }

    public void delete(User user) {
        entityManager.remove(user);
    }
}

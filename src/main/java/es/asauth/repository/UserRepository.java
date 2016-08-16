package es.asauth.repository;

import es.asauth.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u").getResultList();
    }

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }
}

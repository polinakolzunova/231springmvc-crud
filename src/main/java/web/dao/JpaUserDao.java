package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(value = "etm")
public class JpaUserDao implements UserDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void remove(User user) {
        User managedUser = entityManager.merge(user);
        entityManager.remove(managedUser);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional(value = "etm", readOnly = true)
    public User getById(long id) {
        return entityManager.createQuery("select u from User u where id=:id", User.class)
                .setParameter("id",id)
                .getSingleResult();
    }

    @Override
    @Transactional(value = "etm", readOnly = true)
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u", User.class)
                .getResultList();
    }

}

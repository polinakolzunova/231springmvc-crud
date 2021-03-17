package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoMysql implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
    }

    @Override
    public void remove(long id) {
    }

    @Override
    public void update(User user) {
    }

    @Override
    public User getById(long id) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User", User.class).list();
    }

}

package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private static final AtomicInteger AUTO_ID = new AtomicInteger(3);
    private static final Map<Long, User> users = new HashMap<>();
    static {
        users.put((long) 1, new User(1, "Иван", "Иванов", (byte) 10));
        users.put((long) 2, new User(2, "Robert", "Smith", (byte) 20));
    }

    @Override
    public void add(User user) {
        //sessionFactory.getCurrentSession().save(user);

        user.setId(AUTO_ID.getAndIncrement());
        users.put(user.getId(), user);
    }

    @Override
    public void remove(long id) {
        users.remove(id);
    }

    @Override
    public void update(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User getById(long id) {
        return users.get(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        /*TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();*/

        return new ArrayList<>(users.values());

    }

}

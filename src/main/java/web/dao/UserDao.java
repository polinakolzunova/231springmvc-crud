package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    void remove(User user);

    void update(User user);

    User getById(long id);

    List<User> listUsers();
}

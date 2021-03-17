package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void remove(User user);

    void update(User user);

    User getById(long id);

    List<User> listUsers();
}
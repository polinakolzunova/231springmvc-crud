package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDaoMysql")
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void remove(long id) {
        userDao.remove(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

}
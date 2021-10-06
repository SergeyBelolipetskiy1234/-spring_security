package ru.belolipetsckiy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.belolipetsckiy.dao.UserDao;
import ru.belolipetsckiy.models.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public List<User> index() {
        return userDao.index();
    }

    @Transactional
    @Override
    public User show(int id) {
        return userDao.show(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    @Override
    public void update(int id, User user) {
        userDao.update(id, user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }
}

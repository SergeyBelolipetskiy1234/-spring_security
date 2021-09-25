package ru.belolipetsckiy.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.belolipetsckiy.dao.UserDao;
import ru.belolipetsckiy.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> index() {
        return userDao.index();
    }

    public User show(int id) {
        return userDao.show(id);
    }

    public void save(User user) {
        userDao.save(user);
    }

    public void update(int id, User updateUser) {
        userDao.update(id, updateUser);
    }

    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }
}

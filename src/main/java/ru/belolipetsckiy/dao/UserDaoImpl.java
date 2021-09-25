package ru.belolipetsckiy.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.belolipetsckiy.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> index() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public User show(int id) {
        TypedQuery<User> q = entityManager.createQuery("select u from User u where u.id = :id", User.class);
        q.setParameter("id", id);
        return q.getResultList().stream().findAny().orElse(null);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(int id, User updateUser) {
        User userToBeUpdated= show(id);
        userToBeUpdated.setUsername(updateUser.getUsername());
        userToBeUpdated.setSurname(updateUser.getSurname());
        userToBeUpdated.setAge(updateUser.getAge());
        userToBeUpdated.setEmail(updateUser.getEmail());
    }

    public void delete(int id) {
        Query query = entityManager.createQuery("delete from User u where u.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public User getUserByName(String username) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.username=:username",
                User.class).setParameter("username", username);
        return query.getSingleResult();
    }
}


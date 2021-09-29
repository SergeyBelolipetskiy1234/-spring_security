package ru.belolipetsckiy.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.belolipetsckiy.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getRoles() {
        return entityManager.createQuery("select u from Role u", Role.class).getResultList();
    }

    @Override
    public void save(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void update(Role role) {
    entityManager.merge(role);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Role.class, id));
    }

    @Override
    public Role getRoleByName(String name) {
        TypedQuery<Role> query = entityManager.createQuery("select u from Role u where u.name=:role",
                Role.class).setParameter("role", name);
        return query.getSingleResult();
    }
}

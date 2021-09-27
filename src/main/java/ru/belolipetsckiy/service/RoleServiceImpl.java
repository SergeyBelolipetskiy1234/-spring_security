package ru.belolipetsckiy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.belolipetsckiy.dao.RoleDao;
import ru.belolipetsckiy.models.Role;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    private RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

    @Override
    public void save(Role role) {
    roleDao.save(role);
    }

    @Override
    public void update(Role role) {
    roleDao.update(role);
    }

    @Override
    public void delete(int id) {
    roleDao.delete(id);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }
}

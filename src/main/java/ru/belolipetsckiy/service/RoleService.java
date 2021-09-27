package ru.belolipetsckiy.service;

import ru.belolipetsckiy.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
    void save(Role role);
    void update(Role role);
    void delete(int id);
    Role getRoleByName(String name);
}

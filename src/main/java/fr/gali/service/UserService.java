package fr.gali.service;

import fr.gali.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User save(User user);
    void delete(String id);
    User getById(String id);
}

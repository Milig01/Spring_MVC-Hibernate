package org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void update(User user);
    void deleteById(long id);
    User findById(long id);
    List<User> findAll();
}

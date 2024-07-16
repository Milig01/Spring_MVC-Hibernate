package org.example.repository;

import org.example.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    User findById(long id);
    List<User> findAll();
    void deleteById(long id);
    void update(User user);
}

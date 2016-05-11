package com.tolfel.springrest.repositories;

import com.tolfel.springrest.entity.User;

import java.util.List;

public interface UserDao {

    User findById(int id);

    User findByLogin(String login);

    void save(User user);

    void deleteByLogin(String login);

    List<User> findAllUsers();

    List<User> findUsersSortBy(String sort);

}

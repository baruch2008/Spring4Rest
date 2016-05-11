package com.tolfel.springrest.services;

import com.tolfel.springrest.entity.User;

import java.util.List;

public interface UserService {

    User findById(int id);

    User findByLogin(String login);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserByLogin(String login);

    List<User> findAllUsersSortBy(String sort);

    //boolean isUserSSOUnique(Integer id, String sso);
}

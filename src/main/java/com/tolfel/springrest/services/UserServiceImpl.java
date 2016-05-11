package com.tolfel.springrest.services;

import java.util.*;

import com.tolfel.springrest.entity.Tournament;
import com.tolfel.springrest.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tolfel.springrest.repositories.UserDao;
import com.tolfel.springrest.entity.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao dao;

    public User findById(int id) {
        return dao.findById(id);
    }

    public User findByLogin(String login) {
        System.out.println("Finding User with login " + login);
        User user = dao.findByLogin(login);
        System.out.println("User = " + user!=null?true:false);
        return user;
    }

    public void saveUser(User user) {
        dao.save(user);
    }


    public void updateUser(User user) {
        User entity = dao.findById(user.getId());
        if(entity!=null){
            entity.setLogin(user.getLogin());
            entity.setPassword(user.getPassword());
            entity.setRating(user.getRating());
            entity.setEmail(user.getEmail());
            entity.setSteamUrl(user.getSteamUrl());
            entity.setUserProfiles(user.getUserProfiles());
        }
    }


    public void deleteUserByLogin(String login) {
        dao.deleteByLogin(login);
    }

    public List<User> findAllUsersSortBy(String sort) {
        List<User> users = dao.findUsersSortBy(sort);
        Iterator<User> iterator = users.listIterator();
        while(iterator.hasNext())
        {
            User next = iterator.next();
            next.setUserProfiles(new HashSet<UserProfile>());
            next.setTournaments(new HashSet<Tournament>());
        }
        return users;
    }
    /*
    public boolean isUserSSOUnique(Integer id, String sso) {
        User user = findBySSO(sso);
        return ( user == null || ((id != null) && (user.getId() == id)));
    }
    */

}
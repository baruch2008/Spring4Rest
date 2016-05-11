package com.tolfel.springrest.controllers;

import java.util.List;
import java.util.Locale;

import com.tolfel.springrest.entity.User;
import com.tolfel.springrest.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/users/sort={sort}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listUsers(@PathVariable("sort") String sort) {
        if(!sort.equals("login") & !sort.equals("rating")) {
            return new ResponseEntity<List<User>>(HttpStatus.BAD_REQUEST);
        }
        List<User> users = userService.findAllUsersSortBy(sort);
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/id={id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/login={login}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserByLogin(@PathVariable("login") String login) {
        System.out.println("Fetching User with login " + login);
        User user = userService.findByLogin(login);
        if (user == null) {
            System.out.println("User with login " + login + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{login}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUserByLogin(@PathVariable("login") String login) {
        System.out.println("Fetching & Deleting User with login " + login);

        User user = userService.findByLogin(login);
        if (user == null) {
            System.out.println("Unable to delete. User with login " + login + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        userService.deleteUserByLogin(login);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

}

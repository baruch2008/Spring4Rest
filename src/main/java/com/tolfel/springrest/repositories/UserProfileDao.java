package com.tolfel.springrest.repositories;


import com.tolfel.springrest.entity.UserProfile;

import java.util.List;

public interface UserProfileDao {

    List<UserProfile> findAll();

    UserProfile findByType(String type);

    UserProfile findById(int id);
}

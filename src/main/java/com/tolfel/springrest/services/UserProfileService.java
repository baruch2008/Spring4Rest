package com.tolfel.springrest.services;

import com.tolfel.springrest.entity.UserProfile;

import java.util.List;

public interface UserProfileService {

    UserProfile findById(int id);

    UserProfile findByType(String type);

    List<UserProfile> findAll();
}

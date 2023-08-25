package com.example.TAsk.service;

import com.example.TAsk.entity.Profile;

import java.util.List;

public interface ProfileService {
    Profile save(Profile profile);
    List<Profile> get();
    void delete(Long profile_id);

}

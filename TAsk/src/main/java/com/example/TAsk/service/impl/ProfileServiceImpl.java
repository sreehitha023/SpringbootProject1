package com.example.TAsk.service.impl;

import com.example.TAsk.entity.Profile;
import com.example.TAsk.repository.ProfileRepository;
import com.example.TAsk.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    public Profile save(Profile profile){
        return profileRepository.save(profile);
    }

    public List<Profile> get(){
        return profileRepository.findAll();
    }

    public void delete(Long profile_id){
        profileRepository.deleteById(profile_id);
    }
}

package com.lcwd.user.service.Impl;

import com.lcwd.user.service.Entities.User;
import com.lcwd.user.service.Repositories.UserRepository;
import com.lcwd.user.service.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        String randomuserId= UUID.randomUUID().toString();
        user.setUserId(randomuserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return  userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(()->new RuntimeException("Given user id is not found on server:"+userId));

    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}

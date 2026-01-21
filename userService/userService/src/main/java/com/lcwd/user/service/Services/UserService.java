package com.lcwd.user.service.Services;

import com.lcwd.user.service.Entities.User;

import java.util.List;

public interface UserService {
    //user service opertaions
    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);

    void deleteUser(String userId);

    //Update

}

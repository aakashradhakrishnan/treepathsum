package com.aakash.treepathsum.service;

import com.aakash.treepathsum.model.User;
import com.aakash.treepathsum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void registerUser(User user) {
        userRepository.save(user);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}

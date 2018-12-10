package com.aakash.treepathsum.service;

import com.aakash.treepathsum.model.User;
import com.aakash.treepathsum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email){

        Set<GrantedAuthority> defaultRoles = new HashSet<>();

        User user = userRepository.findByEmail(email);

        org.springframework.security.core.userdetails.User.UserBuilder userBuilder = null;
        if(user!=null) {
            userBuilder = org.springframework.security.core.userdetails.User.withUsername(user.getEmail());
            userBuilder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
            userBuilder.roles("ADMIN");
            //return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true, true, true, defaultRoles);
        }else{
            throw new UsernameNotFoundException("Username does not exist");
        }

        return userBuilder.build();
    }
}

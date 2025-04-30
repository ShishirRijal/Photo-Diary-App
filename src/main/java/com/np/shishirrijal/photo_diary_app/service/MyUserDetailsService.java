package com.np.shishirrijal.photo_diary_app.service;

import com.np.shishirrijal.photo_diary_app.model.PrincipalUser;
import com.np.shishirrijal.photo_diary_app.model.User;
import com.np.shishirrijal.photo_diary_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null) {
            System.out.println("Error: User not found with provided username");
           throw new UsernameNotFoundException("User with specified username not found!");
        }

        return new PrincipalUser(user);
    }
}
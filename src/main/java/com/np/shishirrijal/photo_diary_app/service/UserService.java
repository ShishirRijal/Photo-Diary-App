package com.np.shishirrijal.photo_diary_app.service;

import com.np.shishirrijal.photo_diary_app.model.LoginRequest;
import com.np.shishirrijal.photo_diary_app.model.User;
import com.np.shishirrijal.photo_diary_app.repository.UserRepository;
import com.np.shishirrijal.photo_diary_app.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;


    public User createUser(User user) {
        return userRepository.save(user);
    }


    public User getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

     public List<User> getAllUsers() {
        return userRepository.findAll();
    }

     public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    public String verify(LoginRequest request) {
        System.out.println("Authentication: inside");
         try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
             System.out.println("Authentication: " + authentication);
            if (authentication.isAuthenticated()) {
                System.out.println("Authentication: token " + jwtUtil.generateToken(request.getEmail()));
                return jwtUtil.generateToken(request.getEmail());
            }
             System.out.println("invalid credentials");
            throw new BadCredentialsException("Invalid credentials");
        } catch (BadCredentialsException e) {
             System.out.println("invalid email");
            throw new BadCredentialsException("Invalid email or password");
        }
    }
}
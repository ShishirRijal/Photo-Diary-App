package com.np.shishirrijal.photo_diary_app.contoller;

import com.np.shishirrijal.photo_diary_app.model.User;
import com.np.shishirrijal.photo_diary_app.repository.UserRepository;
//import com.np.shishirrijal.photo_diary_app.service.MyUserDetailsService;
//import com.np.shishirrijal.photo_diary_app.util.JwtUtil;
import com.np.shishirrijal.photo_diary_app.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

//    @Autowired
//    private AuthenticationManager authenticationManager;

//    @Autowired
//    private MyUserDetailsService userDetailsService;
//
//    @Autowired
//    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User newUser = userService.createUser(user);
        return ResponseEntity.ok().body(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok("Login successful!");
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
//
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
//        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
//        return ResponseEntity.ok(jwt);
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");

    }



}


class AuthRequest {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


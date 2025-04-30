package com.np.shishirrijal.photo_diary_app.repository;

import com.np.shishirrijal.photo_diary_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

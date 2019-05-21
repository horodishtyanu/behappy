package com.serverside.behappy.repos;

import com.serverside.behappy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    List<User> findAllByEmail(String email);
}

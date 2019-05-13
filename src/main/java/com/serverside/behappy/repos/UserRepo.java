package com.serverside.behappy.repos;

import com.serverside.behappy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findAllByEmailAndPassword(String email, String password);
    List<User> findAllByEmail(String email);
}

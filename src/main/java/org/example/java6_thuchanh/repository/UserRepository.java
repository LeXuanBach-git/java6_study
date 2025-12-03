package org.example.java6_thuchanh.repository;


import org.example.java6_thuchanh.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameOrEmail(String username, String email);

    Boolean existsByEmail(String email);

    Boolean existsByUsernameOrEmail(String username, String email); // check email hoac username da dang ki chua

    Boolean existsByUsername(String username);
}



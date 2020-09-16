package com.turchyn.springbootapp2.repository;

import com.turchyn.springbootapp2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}

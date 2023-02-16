package com.gdschanyang.todayfeelingbackend2.repository;

import com.gdschanyang.todayfeelingbackend2.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    Optional<User> findById(Long id);
    Optional<User> findByName(String name);

    List<User> findAll();

}

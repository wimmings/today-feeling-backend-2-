package com.gdschanyang.todayfeelingbackend2.repository;

import com.gdschanyang.todayfeelingbackend2.domain.posts.Posts;
import com.gdschanyang.todayfeelingbackend2.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    Posts save(Posts posts);

    Optional<Posts> findById(Long id);
    Optional<Posts> findByAuthor(String name);

    List<Posts> findAll();
}

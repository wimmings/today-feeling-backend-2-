package com.gdschanyang.todayfeelingbackend2.repository;

import com.gdschanyang.todayfeelingbackend2.domain.posts.FeelingPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostsRepository extends JpaRepository<FeelingPost, Long> {


}

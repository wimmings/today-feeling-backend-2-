package com.gdschanyang.todayfeelingbackend2.repository;

import com.gdschanyang.todayfeelingbackend2.domain.posts.FeelingPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeelingPostRepository extends JpaRepository<FeelingPost, Long> {


}

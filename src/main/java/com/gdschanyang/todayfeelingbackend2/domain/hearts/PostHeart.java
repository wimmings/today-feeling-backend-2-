package com.gdschanyang.todayfeelingbackend2.domain.hearts;

import com.gdschanyang.todayfeelingbackend2.domain.posts.FeelingPost;
import com.gdschanyang.todayfeelingbackend2.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class PostHeart {
    // 공감한 유저, 공감한 감정글
    @Id
    private Long id;

    // PostHeart : User = 1 : n 매핑
    @OneToMany
    @JoinColumn(name = "FEELING_HEART_USER")
    private List<User> users = new ArrayList<User>();

    // PostHeart : FeelingPost = 1 : n 매핑
    @OneToMany
    @JoinColumn(name = "FEELING_HEART_POST")
    private List<FeelingPost> feelingPosts = new ArrayList<FeelingPost>();

}

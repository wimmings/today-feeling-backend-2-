package com.gdschanyang.todayfeelingbackend2.domain.hearts;

import com.gdschanyang.todayfeelingbackend2.domain.posts.ClinicPost;
import com.gdschanyang.todayfeelingbackend2.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class ClinicHeart {
    // 공감한 유저, 공감한 클리닉 글
    @Id
    private Long id;

    // ClinicHeart : User = 1 : n 매핑
    @OneToMany
    @JoinColumn(name = "CLINIC_HEART_USER")
    private List<User> users = new ArrayList<User>();

    // ClinicHeart : ClinicPost = 1 : n 매핑
    @OneToMany
    @JoinColumn(name = "CLINIC_HEART_POST")
    private List<ClinicPost> ClinicPosts = new ArrayList<ClinicPost>();

}

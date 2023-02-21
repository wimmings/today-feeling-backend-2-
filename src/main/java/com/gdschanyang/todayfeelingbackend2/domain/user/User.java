package com.gdschanyang.todayfeelingbackend2.domain.user;


import com.gdschanyang.todayfeelingbackend2.domain.hearts.ClinicHeart;
import com.gdschanyang.todayfeelingbackend2.domain.hearts.FeelingHeart;
import com.gdschanyang.todayfeelingbackend2.domain.posts.ClinicPost;
import com.gdschanyang.todayfeelingbackend2.domain.posts.FeelingPost;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_NAME", nullable = false)
    private String name;

    // 1. User : FeelingPost = 1 : n -> 한 유저가 여러 감정글 작성
    @OneToMany(mappedBy = "user")
    private List<FeelingPost> feelingPosts = new ArrayList<FeelingPost>();

    // 1. User : ClinicPost = 1 : n -> 한 유저가 여러 클리닉글 작성
    @OneToMany(mappedBy = "user")
    private List<ClinicPost> clinicPosts = new ArrayList<ClinicPost>();

    // 2. User : FeelingHeart = 1 : n
    @OneToMany(mappedBy = "user")
    private List<FeelingHeart> feelingHearts = new ArrayList<FeelingHeart>();

    // 2. User : ClinicHeart = 1 : n
    @OneToMany(mappedBy = "user")
    private List<ClinicHeart> clinicHearts = new ArrayList<ClinicHeart>();

    public void addFeelingPost(FeelingPost feelingPost) {
        this.feelingPosts.add(feelingPost);
        if (feelingPost.getUser() != this) {
            feelingPost.setUser(this);
        }
    }

    public void addFeelingHeart(FeelingHeart feelingHeart){
        this.feelingHearts.add(feelingHeart);
        if(feelingHeart.getUser() != this){
            feelingHeart.setUser(this);
        }
    }
    public void addClinicPost(ClinicPost clinicPost) {
        this.clinicPosts.add(clinicPost);
        if (clinicPost.getUser() != this) {
            clinicPost.setUser(this);
        }
    }
    public void addClinicHeart(ClinicHeart clinicHeart){
        this.clinicHearts.add((clinicHeart));
        if(clinicHeart.getUser() != this){
            clinicHeart.setUser(this);
        }
    }
}

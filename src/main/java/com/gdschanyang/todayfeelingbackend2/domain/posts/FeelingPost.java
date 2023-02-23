package com.gdschanyang.todayfeelingbackend2.domain.posts;


import com.gdschanyang.todayfeelingbackend2.domain.hearts.FeelingHeart;
import com.gdschanyang.todayfeelingbackend2.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class FeelingPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FEELINGPOST_ID")
    private Long id;

    @Column(nullable = false)
    private Feeling feeling;

    // 글 작성은 선택적
    @Column(columnDefinition = "TEXT")
    private String content;

    // 1. FeelingPost : User = n : 1
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    // 3. FeelingPost : FeelingHeart = 1 : n
    @OneToMany(mappedBy = "feelingPost")
    private List<FeelingHeart> feelingHearts = new ArrayList<FeelingHeart>();

    // 삭제 여부 1:삭제 0:삭제X
    @Column(nullable = false)
    private boolean delFlag; //다시

    public void setUser(User user) {
        this.user = user;
        if (!user.getFeelingPosts().contains(this)) {
            user.getFeelingPosts().add(this);
        }
    }

    public void addFeelingPost(FeelingHeart feelingHeart){
        this.feelingHearts.add(feelingHeart);
        if(feelingHeart.getFeelingPost() != this){
            feelingHeart.setFeelingPost(this);
        }
    }
}

package com.gdschanyang.todayfeelingbackend2.domain.hearts;

import com.gdschanyang.todayfeelingbackend2.domain.posts.FeelingPost;
import com.gdschanyang.todayfeelingbackend2.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
public class FeelingHeart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FEELINGHEART_ID")
    private Long id;

    // 2. FeelingHeart : User = n : 1
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    // 3. FeelingHeart : FeelingPost = n : 1
    @ManyToOne
    @JoinColumn(name = "FEELINGPOST_ID")
    private FeelingPost feelingPost;

    @Builder
    public FeelingHeart() {
        this.user.addFeelingHeart(this);
        this.feelingPost.addFeelingPost(this);
    }


}

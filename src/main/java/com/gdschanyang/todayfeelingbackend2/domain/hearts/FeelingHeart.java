package com.gdschanyang.todayfeelingbackend2.domain.hearts;

import com.gdschanyang.todayfeelingbackend2.domain.posts.FeelingPost;
import com.gdschanyang.todayfeelingbackend2.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
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

    public void setUser(User user){
        this.user  = user;
        if(!user.getFeelingHearts().contains(this)){
            user.getFeelingHearts().add(this);
        }
    }

    public void setFeelingPost(FeelingPost feelingPost){
        this.feelingPost = feelingPost;
        if(!feelingPost.getFeelingHearts().contains(this)){
            feelingPost.getFeelingHearts().add(this);
        }
    }

}

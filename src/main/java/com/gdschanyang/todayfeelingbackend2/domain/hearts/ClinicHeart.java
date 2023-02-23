package com.gdschanyang.todayfeelingbackend2.domain.hearts;

import com.gdschanyang.todayfeelingbackend2.domain.posts.ClinicPost;
import com.gdschanyang.todayfeelingbackend2.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ClinicHeart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLINICHEART_ID")
    private Long id;

    // 2. ClinicHeart : User = n : 1
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    // 3. ClinicHeart : ClinicPost = n : 1
    @ManyToOne
    @JoinColumn(name = "CLINICPOST_ID")
    private ClinicPost clinicPost;

    public void setUser(User user){
        this.user = user;
        if(!user.getClinicHearts().contains(this)){
            user.getClinicHearts().add(this);
        }
    }

    public void setClinicPost(ClinicPost clinicPost){
        this.clinicPost = clinicPost;
        if(!clinicPost.getClinicHearts().contains(this)){
            clinicPost.getClinicHearts().add(this);
        }
    }

}

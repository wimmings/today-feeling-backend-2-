package com.gdschanyang.todayfeelingbackend2.domain.hearts;

import com.gdschanyang.todayfeelingbackend2.domain.posts.ClinicPost;
import com.gdschanyang.todayfeelingbackend2.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
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

    @Builder
    public ClinicHeart() {
        this.user.addClinicHeart(this);
        this.clinicPost.addClinicPost(this);
    }

}

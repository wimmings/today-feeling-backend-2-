package com.gdschanyang.todayfeelingbackend2.domain.posts;

import com.gdschanyang.todayfeelingbackend2.domain.hearts.ClinicHeart;
import com.gdschanyang.todayfeelingbackend2.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class ClinicPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLINICPOST_ID")
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    // 글 작성은 필수
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    // 1. ClinicPost : User = n : 1
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    // 3. ClinicPost : ClinicHeart = 1 : n
    @OneToMany(mappedBy = "clinicPost")
    private List<ClinicHeart> clinicHearts = new ArrayList<ClinicHeart>();

    @Builder
    public ClinicPost() {
        this.user.addClinicPost(this);
    }

    public void addClinicPost(ClinicHeart clinicHeart){
        this.clinicHearts.add(clinicHeart);
    }
}

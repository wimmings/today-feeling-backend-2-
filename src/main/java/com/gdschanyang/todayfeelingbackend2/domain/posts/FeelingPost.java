package com.gdschanyang.todayfeelingbackend2.domain.posts;


import com.gdschanyang.todayfeelingbackend2.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class FeelingPost {
    // 감정, 글, 글 쓴 사람, 삭제 여부
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Feeling feeling;

    // 글 작성은 선택적
    @Column(columnDefinition = "TEXT")
    private String content;

    // User 와 FeelingPost 1:1 매핑
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    // 삭제 여부 1:삭제 0:삭제X
    @Column(nullable = false)
    private boolean delFlag;

}

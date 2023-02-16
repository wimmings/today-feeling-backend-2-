package com.gdschanyang.todayfeelingbackend2.domain.posts;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Feelings feelings;

    @Column(length = 500, nullable = false)
    private String title;

    // 글 작성은 선택적
    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private String author;
}

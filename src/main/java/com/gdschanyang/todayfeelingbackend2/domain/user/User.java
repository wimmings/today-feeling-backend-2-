package com.gdschanyang.todayfeelingbackend2.domain.user;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    // 본명
    @Column(name = "USER_REALNAME", nullable = false)
    private String realName;

    // 닉네임으로 대나무숲과 클릭닉 센터에서 활동
    @Column(name = "USER_NICKNAME", nullable = false)
    private String nickName;

}

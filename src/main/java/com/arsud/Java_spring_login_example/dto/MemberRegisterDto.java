package com.arsud.Java_spring_login_example.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MemberRegisterDto {

    private String username;
    private String password;
}

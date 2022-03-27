package com.arsud.Java_spring_login_example.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MemberRegisterDto {

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String password_confirm;

    @NonNull
    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식이 맞지 않습니다.")
    private String mail;
}

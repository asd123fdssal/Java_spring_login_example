package com.arsud.Java_spring_login_example.service;

import com.arsud.Java_spring_login_example.entity.Member;
import com.arsud.Java_spring_login_example.exception.AlreadyRegisteredUserException;
import com.arsud.Java_spring_login_example.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder encryptor;

    public Member signup(
            String username,
            String password
    ) {
        if (memberRepository.findByUsername(username) != null) {
            throw new AlreadyRegisteredUserException();
        }
        return memberRepository.save(new Member(username, encryptor.encode(password), "ROLE_USER"));
    }

    public Member findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

}

package com.arsud.Java_spring_login_example.controller;

import com.arsud.Java_spring_login_example.dto.MemberRegisterDto;
import com.arsud.Java_spring_login_example.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignupController {

    private final MemberService memberService;

    @GetMapping
    public String signup(
            Model model
    ){
        model.addAttribute("MemberRegisterDto", new MemberRegisterDto());
        return "signup";
    }

    @PostMapping
    public String signup(
            @ModelAttribute MemberRegisterDto memberDto
            ){
        memberService.signup(memberDto.getUsername(), memberDto.getPassword());
        return "login";
    }

}

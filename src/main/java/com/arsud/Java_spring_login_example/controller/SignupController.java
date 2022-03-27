package com.arsud.Java_spring_login_example.controller;

import com.arsud.Java_spring_login_example.dto.MemberRegisterDto;
import com.arsud.Java_spring_login_example.exception.AlreadyRegisteredUserException;
import com.arsud.Java_spring_login_example.service.MemberService;
import com.arsud.Java_spring_login_example.validator.RegisterValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignupController {

    private final MemberService memberService;
    private final RegisterValidator registerValidator;

    @GetMapping
    public String signup(
            Model model
    ){
        model.addAttribute("MemberRegisterDto", new MemberRegisterDto());
        return "signup";
    }

    @InitBinder(value = "signup")
    public void initBinder(
            WebDataBinder webDataBinder
    ){
        webDataBinder.addValidators(registerValidator);
    }

    @PostMapping
    public String signup(
            @Valid @ModelAttribute("MemberRegisterDto") MemberRegisterDto memberDto,
            BindingResult bindingResult
    ){
        registerValidator.validate(memberDto, bindingResult);

        if(bindingResult.hasErrors()){
            return "/signup";
        }

        try {
            memberService.signup(memberDto.getUsername(), memberDto.getPassword());
        } catch (AlreadyRegisteredUserException e){
            bindingResult.rejectValue("username", "duplicate_user", "이미 존재하는 ID 입니다.");
            return "/signup";
        }

        return "login";
    }

}

package com.arsud.Java_spring_login_example.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
        super("아이디 또는 비밀번호가 일치하지 않습니다.");
    }

}

package com.arsud.Java_spring_login_example.exception;

public class AlreadyRegisteredUserException extends RuntimeException {

    public AlreadyRegisteredUserException(String message) {
        super(message);
    }

    public AlreadyRegisteredUserException() {
        super("이미 존재하는 아이디입니다.");
    }

}

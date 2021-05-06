package com.dan.task5.exception;

public class BoardingPassesNotFoundException extends RuntimeException{

    public BoardingPassesNotFoundException(String message) {
        super(message);
    }
}

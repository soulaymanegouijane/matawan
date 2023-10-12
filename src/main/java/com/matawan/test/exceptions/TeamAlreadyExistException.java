package com.matawan.test.exceptions;

public class TeamAlreadyExistException extends Exception {
    public TeamAlreadyExistException(String message) {
        super(message);
    }

}

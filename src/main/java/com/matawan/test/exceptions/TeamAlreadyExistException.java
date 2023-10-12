package com.matawan.test.exceptions;
/**
 * This exception is thrown when an attempt is made to create a team with a name or acronym that already exists.
 */
public class TeamAlreadyExistException extends Exception {
    /**
     * Constructor for the exception.
     * @param message detailed message describing the reason for the exception
     */
    public TeamAlreadyExistException(String message) {
        super(message);
    }

}

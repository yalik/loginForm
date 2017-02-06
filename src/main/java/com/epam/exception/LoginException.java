package com.epam.exception;

/**
 * Created by Konstantin Yalovik on 30.01.2017.
 */
public class LoginException extends RuntimeException{
    public LoginException() {
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginException(Throwable cause) {
        super(cause);
    }
}

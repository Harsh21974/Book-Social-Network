package com.example.book_network.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum BusinessErrorCodes {
    NO_CODE(0, HttpStatus.NOT_IMPLEMENTED, "No Code"),
    INCORRECT_CURRENT_PASSWORD(300, HttpStatus.BAD_REQUEST, "Current password is incorrect"),
    NEW_PASSWORD_DOES_NOT_MATCH(301, HttpStatus.FORBIDDEN, "The new password does not match"),
    ACCOUNT_DISABLED(303, HttpStatus.FORBIDDEN, "User account is disabled"),
    ACCOUNT_LOCKED(302, HttpStatus.FORBIDDEN, "User account is locked"),
    BAD_CREDENTIALS(304, HttpStatus.FORBIDDEN, "Login and / or password is incorrect");

    @Getter
    private final int code;

    @Getter
    private final HttpStatus status;
    @Getter
    private final String description;

    BusinessErrorCodes(int code, HttpStatus status, String description) {

        this.code = code;
        this.status = status;
        this.description = description;
    }
}

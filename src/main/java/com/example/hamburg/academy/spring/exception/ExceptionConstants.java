package com.example.hamburg.academy.spring.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionConstants {
    UNEXPECTED_EXCEPTION("UNEXPECTED_EXCEPTION", "Unexpected exception occurred"),
    HTTP_METHOD_IS_NOT_CORRECT("HTTP_METHOD_IS_NOT_CORRECT", "Http method is not correct"),
    JURISDICTION_NOT_FOUND("JURISDICTION_NOT_FOUND", "Jurisdiction is not found");

    private final String code;
    private final String message;

    public String getMessage(String id) {
        if ((this == JURISDICTION_NOT_FOUND) && id != null) {
            return String.format("%s (ID: %s)", this.message, id);
        }
        return this.message;
    }
}

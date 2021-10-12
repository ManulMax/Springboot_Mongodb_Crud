package com.mongocrud.springcrudmongo.exception;

public enum EnumException {
    UserNotFound("User Not Found","404");
    private String errorMessage;
    private String errorCode;

    EnumException(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

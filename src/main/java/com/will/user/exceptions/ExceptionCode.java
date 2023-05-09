package com.will.user.exceptions;

public enum ExceptionCode {

    F_I_001("F_I_001", "It was not possible to create an User."),
    F_I_002("F_I_002", "It was not possible to update an User."),
    F_I_003("F_I_003", "It was not possible to delete an User.");

    private final String code;
    private final String friendlyMessage;

    ExceptionCode(String code, String friendlyMessage) {
        this.code = code;
        this.friendlyMessage = friendlyMessage;
    }

    public String getCode() {
        return code;
    }

    public String getFriendlyMessage() {
        return friendlyMessage;
    }
}

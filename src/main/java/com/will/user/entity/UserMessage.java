package com.will.user.entity;

public class UserMessage {

    private String name;
    private String email;
    private String cellphoneNumber;

    public UserMessage() {
    }

    public UserMessage(String name, String email, String cellphoneNumber) {
        this.name = name;
        this.email = email;
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }
}

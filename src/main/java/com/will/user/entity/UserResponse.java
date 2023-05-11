package com.will.user.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserResponse implements Serializable {

    private String name;
    private String email;
    private String cellphoneNumber;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResponse that = (UserResponse) o;
        return Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(cellphoneNumber, that.cellphoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, cellphoneNumber);
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cellphoneNumber='" + cellphoneNumber + '\'' +
                '}';
    }
}

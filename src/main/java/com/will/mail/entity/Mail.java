package com.will.mail.entity;

import com.will.ingredients.entity.Ingredient;
import com.will.user.entity.User;

import java.util.List;
import java.util.Objects;

public class Mail {

    private List<User> userName;
    private List<Ingredient> ingredientList;

    public Mail() {
    }

    public Mail(List<User> userName, List<Ingredient> ingredientList) {
        this.userName = userName;
        this.ingredientList = ingredientList;
    }

    public List<User> getUserName() {
        return userName;
    }

    public void setUserName(List<User> userName) {
        this.userName = userName;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mail mail = (Mail) o;
        return Objects.equals(userName, mail.userName) && Objects.equals(ingredientList, mail.ingredientList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, ingredientList);
    }
}

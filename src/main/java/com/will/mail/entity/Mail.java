package com.will.mail.entity;

import com.will.ingredients.entity.IngredientMessage;
import com.will.user.entity.UserMessage;

import java.util.List;

public class Mail {

    private List<UserMessage> userList;
    private List<IngredientMessage> ingredientList;

    public Mail() {
    }

    public List<UserMessage> getUserList() {
        return userList;
    }

    public void setUserList(List<UserMessage> userList) {
        this.userList = userList;
    }

    public List<IngredientMessage> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<IngredientMessage> ingredientList) {
        this.ingredientList = ingredientList;
    }
}

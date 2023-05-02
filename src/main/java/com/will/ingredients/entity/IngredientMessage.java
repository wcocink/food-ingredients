package com.will.ingredients.entity;

public class IngredientMessage {

    private String name;
    private Double quantityInKg;

    public IngredientMessage() {
    }

    public IngredientMessage(String name, Double quantityInKg) {
        this.name = name;
        this.quantityInKg = quantityInKg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantityInKg() {
        return quantityInKg;
    }

    public void setQuantityInKg(Double quantityInKg) {
        this.quantityInKg = quantityInKg;
    }
}

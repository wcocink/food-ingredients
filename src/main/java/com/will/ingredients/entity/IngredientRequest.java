package com.will.ingredients.entity;

public class IngredientRequest {

    private String name;
    private Double quantityInKg;

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

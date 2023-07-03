package com.will.ingredients.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class IngredientResponse {

    private String name;
    private Double quantityInKg;
}

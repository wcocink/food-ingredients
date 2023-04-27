package com.will.ingredients.control;

import com.will.ingredients.entity.Ingredient;
import com.will.ingredients.entity.IngredientRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Transactional
public class IngredientController {

    @Inject
    IngredientRepository ingredientRepository;

    public Response createIngredient(IngredientRequest ingredientRequest){
        ingredientRepository.persist(mapIngredientRequestToIngredient(ingredientRequest));
        return Response.status(Response.Status.CREATED).build();
    }

    public Response listIngredients() {
        return Response.ok(ingredientRepository.findAll().list()).build();
    }

    public Response updateIngredient(Long ingredientId, IngredientRequest ingredientRequest) {
        var ingredient = findIngredientById(ingredientId);
        if(ingredient != null){
            ingredient.setName(ingredientRequest.getName());
            ingredient.setQuantityInKg(ingredientRequest.getQuantityInKg());
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public Response updateIngredientQuantity(Long ingredientId, Double quantity) {
        var ingredient = findIngredientById(ingredientId);
        if(ingredient != null){
            ingredient.setQuantityInKg(quantity);
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    public Response deleteIngredient(Long ingredientId) {
        var ingredient = findIngredientById(ingredientId);
        if(ingredient != null){
            ingredientRepository.delete(ingredient);
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    public Response getIngredientById(Long ingredientId) {
        var ingredient = findIngredientById(ingredientId);
        if(ingredient != null){
            return Response.ok(ingredient).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    private Ingredient findIngredientById(Long ingredientId){
        return ingredientRepository.findById(ingredientId);
    }

    private Ingredient mapIngredientRequestToIngredient(IngredientRequest ingredientRequest){
        var ingredient = new Ingredient();
        ingredient.setName(ingredientRequest.getName());
        ingredient.setQuantityInKg(ingredientRequest.getQuantityInKg());
        return ingredient;
    }


}

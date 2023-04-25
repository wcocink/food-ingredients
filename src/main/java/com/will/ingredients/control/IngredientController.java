package com.will.ingredients.control;

import com.will.ingredients.entity.IngredientRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class IngredientController {

    @Inject
    IngredientRepository ingredientRepository;

    public Response createIngredient(IngredientRequest ingredientRequest){
        return Response.status(Response.Status.CREATED).build();
    }

    public Response listIngredients() {
        return Response.status(Response.Status.OK).build();
    }

    public Response updateIngredient(IngredientRequest ingredientRequest) {
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public Response deleteIngredient(Long ingredientId) {
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}

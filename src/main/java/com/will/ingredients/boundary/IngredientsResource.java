package com.will.ingredients.boundary;

import com.will.ingredients.control.IngredientController;
import com.will.ingredients.entity.IngredientRequest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ingredient")
public class IngredientsResource {

    @Inject
    IngredientController ingredientController;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createIngredient(IngredientRequest ingredientRequest) {
        return ingredientController.createIngredient(ingredientRequest);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listIngredients() {
        return ingredientController.listIngredients();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateIngredient(IngredientRequest ingredientRequest) {
        return ingredientController.updateIngredient(ingredientRequest);
    }

    @DELETE
    @Path("/{ingredientId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteIngredient(@PathParam("ingredientId") Long ingredientId) {
        return ingredientController.deleteIngredient(ingredientId);
    }

}

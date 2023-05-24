package com.will.ingredients.boundary;

import com.will.ingredients.control.IngredientController;
import com.will.ingredients.entity.IngredientRequest;
import com.will.ingredients.entity.IngredientResponse;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/ingredients")
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
    public List<IngredientResponse> listIngredients() {
        return ingredientController.listIngredients();
    }

    @GET
    @Path("/{ingredientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIngredientById(@PathParam("ingredientId") Long ingredientId) {
        return ingredientController.getIngredientById(ingredientId);
    }

    @PUT
    @Path("/{ingredientId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateIngredient(@PathParam("ingredientId") Long ingredientId, IngredientRequest ingredientRequest) {
        return ingredientController.updateIngredient(ingredientId, ingredientRequest);
    }

    @PATCH
    @Path("/{ingredientId}/quantities/{quantity}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateIngredientQuantity(@PathParam("ingredientId") Long ingredientId, @PathParam("quantity") Double quantity) {
        return ingredientController.updateIngredientQuantity(ingredientId, quantity);
    }

    @DELETE
    @Path("/{ingredientId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteIngredient(@PathParam("ingredientId") Long ingredientId) {
        return ingredientController.deleteIngredient(ingredientId);
    }

}

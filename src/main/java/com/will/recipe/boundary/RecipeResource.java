package com.will.recipe.boundary;

import com.will.recipe.controller.RecipeFinderController;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/recipes")
public class RecipeResource {

    @Inject
    RecipeFinderController recipeFinderController;

    @GET
    @Path("/ingredient/{ingredientName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecipesByIngredient(@PathParam("ingredientName") String ingredient){
        return recipeFinderController.getRecipesByIngredient(ingredient);
    }

}

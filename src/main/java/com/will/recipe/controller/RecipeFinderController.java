package com.will.recipe.controller;

import com.will.recipe.boundary.RecipeFinderService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class RecipeFinderController {

    @Inject
    @RestClient
    RecipeFinderService recipeFinderService;

    public Response getRecipesByIngredient(String ingredient) {
        return Response.ok(recipeFinderService.getByIngredient(ingredient)).build();
    }

}

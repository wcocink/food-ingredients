package com.will.recipe.boundary;

import com.will.recipe.entity.RecipeResponse;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("/recipes")
@RegisterRestClient
public interface RecipeFinderService {

    @GET
    @ClientHeaderParam(name = "X-RapidAPI-Key", value = "${recipe.finder.api.key}")
    @ClientHeaderParam(name = "X-RapidAPI-Host", value = "${recipe.finder.api.host}")
    List<RecipeResponse> getByIngredient(@QueryParam("ingredient") String ingredient);

}

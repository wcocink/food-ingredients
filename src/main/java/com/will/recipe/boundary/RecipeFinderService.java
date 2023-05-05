package com.will.recipe.boundary;

import com.will.recipe.entity.RecipeResponse;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("/recipes")
@RegisterRestClient
@ClientHeaderParam(
        name = "X-RapidAPI-Key",
        value = {"{getRapidApiKey}"}
)
@ClientHeaderParam(
        name = "X-RapidAPI-Host",
        value = {"{getRapidApiHost}"}
)
public interface RecipeFinderService {

    default String getRapidApiKey() {
        return ConfigProvider.getConfig().getValue("recipe.finder.api.key", String.class);
    }

    default String getRapidApiHost() {
        return ConfigProvider.getConfig().getValue("recipe.finder.api.host", String.class);
    }

    @GET
    List<RecipeResponse> getByIngredient(@QueryParam("ingredient") String ingredient);

}

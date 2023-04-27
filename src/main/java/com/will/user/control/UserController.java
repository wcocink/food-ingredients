package com.will.user.control;

import com.will.ingredients.entity.Ingredient;
import com.will.ingredients.entity.IngredientRequest;
import com.will.user.entity.User;
import com.will.user.entity.UserRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Transactional
public class UserController {

    @Inject
    UserRepository userRepository;

    public Response createUser(UserRequest userRequest) {
        userRepository.persist(mapIngredientRequestToIngredient(userRequest));
        return Response.status(Response.Status.CREATED).build();
    }

    public Response listUsers() {
        return Response.ok(userRepository.findAll().list()).build();
    }

    public Response updateUser(UserRequest userRequest) {
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public Response deleteUser(Long userId) {
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    private User mapIngredientRequestToIngredient(UserRequest userRequest){
        var user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setCellphoneNumber(userRequest.getCellphoneNumber());
        return user;
    }

}

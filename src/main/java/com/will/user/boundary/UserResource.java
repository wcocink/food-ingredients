package com.will.user.boundary;

import com.will.user.control.UserController;
import com.will.user.entity.UserRequest;
import com.will.user.entity.UserResponse;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserResource {

    @Inject
    UserController userController;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(UserRequest userRequest) {
        return userController.createUser(userRequest);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listUsers() {
        return userController.listUsers();
    }

    @PUT
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("userId") Long userId, UserRequest userRequest) {
        return userController.updateUser(userId, userRequest);
    }

    @DELETE
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("userId") Long userId) {
        return userController.deleteUser(userId);
    }

}

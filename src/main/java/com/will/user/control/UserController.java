package com.will.user.control;

import com.will.user.entity.UserRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Transactional
public class UserController {


    public Response createUser(UserRequest userRequest) {
        return Response.status(Response.Status.CREATED).build();
    }


    public Response listUsers() {
        return Response.status(Response.Status.OK).build();
    }


    public Response updateUser(UserRequest userRequest) {
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public Response deleteUser(Long userId) {
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}

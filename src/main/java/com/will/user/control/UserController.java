package com.will.user.control;

import com.will.ingredients.entity.Ingredient;
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
        userRepository.persist(mapUserRequestToUser(userRequest));
        return Response.status(Response.Status.CREATED).build();
    }

    public Response listUsers() {
        return Response.ok(userRepository.findAll().list()).build();
    }

    public Response updateUser(Long userId, UserRequest userRequest) {
        var user = findUserById(userId);
        if(user != null){
            user.setName(userRequest.getName());
            user.setEmail(userRequest.getEmail());
            user.setCellphoneNumber(userRequest.getCellphoneNumber());
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    public Response deleteUser(Long userId) {
        var user = findUserById(userId);
        if(user != null){
            userRepository.delete(user);
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    private User findUserById(Long userId){
        return userRepository.findById(userId);
    }

    private User mapUserRequestToUser(UserRequest userRequest){
        var user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setCellphoneNumber(userRequest.getCellphoneNumber());
        return user;
    }

}

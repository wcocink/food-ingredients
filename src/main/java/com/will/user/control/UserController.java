package com.will.user.control;

import com.will.user.entity.User;
import com.will.user.entity.UserRequest;
import com.will.user.entity.UserResponse;
import com.will.user.exceptions.UserExceptionCode;
import com.will.user.exceptions.UserException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class UserController {

    @Inject
    UserRepository userRepository;

    public List<UserResponse> listUsers() {
        return userRepository.findAll().stream().map(this::mapUserToUserResponse).collect(Collectors.toList());
    }

    public Response createUser(UserRequest userRequest) {
        var user = mapUserRequestToUser(userRequest);
        try{
            userRepository.persist(user);
        }catch (PersistenceException e){
            throw new UserException(UserExceptionCode.F_I_001);
        }
        return Response.status(Response.Status.CREATED).entity(mapUserToUserResponse(user)).build();
    }

    public Response updateUser(Long userId, UserRequest userRequest) {
        var user = findUserById(userId);
        try{
            if(user != null){
                user.setName(userRequest.getName());
                user.setEmail(userRequest.getEmail());
                user.setCellphoneNumber(userRequest.getCellphoneNumber());
                userRepository.flush();
                return Response.status(Response.Status.OK).entity(mapUserToUserResponse(user)).build();
            }
        }catch (Exception e){
            throw new UserException(UserExceptionCode.F_I_002, e.getMessage());
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    public Response deleteUser(Long userId) {
        var user = findUserById(userId);
        try{
            if(user != null){
                userRepository.delete(user);
                return Response.status(Response.Status.NO_CONTENT).build();
            }
        }catch (Exception e){
            throw new UserException(UserExceptionCode.F_I_002, e.getMessage());
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

    private UserResponse mapUserToUserResponse(User user){
        var userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setCellphoneNumber(user.getCellphoneNumber());
        return userResponse;
    }

}

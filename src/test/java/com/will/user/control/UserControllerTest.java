package com.will.user.control;

import com.will.user.entity.UserRequest;
import com.will.user.exceptions.UserException;
import com.will.user.exceptions.UserExceptionCode;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerTest {

    @Inject
    UserController userController;

    @Test
    @DisplayName("Should create an user successfully")
    @Order(1)
    public void create_User_Test(){
        Response response = userController.createUser(new UserRequest("Test", "test@test.test", "123456789"));

        assertEquals(201,response.getStatus());
    }

    @Test
    @DisplayName("Should throw an error when creating user")
    @Order(2)
    public void create_User_Exception_Test(){
        try{
            userController.createUser(new UserRequest("Test", "test@test.test", "123456789"));
        }catch (UserException e){
            assertEquals(UserExceptionCode.F_I_001, e.getExceptionCode());
        }
    }

    @Test
    @DisplayName("Should list all Users successfully")
    @Order(3)
    public void list_Users_Test(){
        var usersList = userController.listUsers();
        assertEquals(1, usersList.size());
    }

//    @Test
//    @DisplayName("Should update an user successfully")
//    @Order(3)
//    public void update_User_Test(){
//
//        assertThrows(UserException.class, () ->
//                userController.createUser(new UserRequest("Test", "test@test.test", "123456789"))
//        );
//    }

}

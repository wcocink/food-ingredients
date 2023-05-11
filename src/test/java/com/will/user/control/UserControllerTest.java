package com.will.user.control;

import com.will.user.entity.UserRequest;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerTest {

    @Inject
    UserController userController;

//    @Test
//    @DisplayName("Should create an user successfully")
//    public void create_User_Test(){
//        Response response = userController.createUser(new UserRequest("Test", "test@test.test", "123456789"));
//        assertEquals(201,response.getStatus());
//    }
//
//    @Test
//    @DisplayName("Should throw an error when creating user")
//    public void create_User_Exception_Test(){
////        try{
//
//        Response response =  userController.createUser(new UserRequest("Test", "test@test.test", "123456789"));
//            //        }catch (UserException e){
////            assertEquals(UserExceptionCode.F_I_001, e.getExceptionCode());
////        }
//    }
//
//    @Test
//    @DisplayName("Should list all Users successfully")
//    @Order(3)
//    @TestTransaction
//    public void list_Users_Test(){
//        var usersList = userController.listUsers();
//        assertEquals(1, usersList.size());
//    }

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

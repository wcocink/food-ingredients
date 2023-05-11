package com.will.user.control;

import com.will.user.entity.User;
import com.will.user.entity.UserRequest;
import com.will.user.exceptions.UserException;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerTest {

    @Inject
    UserController userController;

    @BeforeEach
    public void setup(){
        userController.createUser(new UserRequest("Test", "test@test.test", "123456789"));
    }

    @Test
    @DisplayName("Should create an user successfully")
    public void create_User_Test(){
        assertDoesNotThrow(() -> userController.createUser(new UserRequest("Test", "test2@test.test", "123456789")));
    }

    @Test
    @DisplayName("Should thow a specific error when failing at User Creation")
    public void create_User_Fail_Test(){
        assertThrows(UserException.class, () ->
                userController.createUser(new UserRequest("Test", "test@test.test", "123456789"))
        );
    }

    @Test
    @DisplayName("Should list all Users successfully")
    public void list_Users_Test(){
        assertDoesNotThrow(() -> userController.listUsers());
    }

}

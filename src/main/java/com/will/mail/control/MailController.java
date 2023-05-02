package com.will.mail.control;

import com.will.ingredients.control.IngredientRepository;
import com.will.ingredients.entity.Ingredient;
import com.will.ingredients.entity.IngredientMessage;
import com.will.mail.entity.Mail;
import com.will.user.control.UserRepository;
import com.will.user.entity.User;
import com.will.user.entity.UserMessage;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class MailController {

    @Inject
    UserRepository userRepository;

    @Inject
    IngredientRepository ingredientRepository;

    @Inject
    @Channel("food-ingredients-out")
    Emitter<Mail> emitter;

    public Response sendMail(){

        List<User> userList = userRepository.listAll();
        List<Ingredient> ingredientList = ingredientRepository.listAll();

        if(userList.size() > 0){
            Mail mail = new Mail();
            mail.setUserList(mapUserListToUserMessageList(userList));
            mail.setIngredientList(mapIngredientListToIngredientMessageList(ingredientList));
            emitter.send(mail);
            return Response.status(Response.Status.NO_CONTENT).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();

    }

    private List<UserMessage> mapUserListToUserMessageList(List<User> userList){
        return userList.stream()
                .map(user -> new UserMessage(user.getName(), user.getEmail(), user.getCellphoneNumber())).toList();
    }

    private List<IngredientMessage> mapIngredientListToIngredientMessageList(List<Ingredient> ingredientList){
        return ingredientList.stream()
                .map(ingredient -> new IngredientMessage(ingredient.getName(), ingredient.getQuantityInKg())).toList();
    }

}

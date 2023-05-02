package com.will.mail.control;

import com.will.ingredients.control.IngredientRepository;
import com.will.ingredients.entity.Ingredient;
import com.will.mail.entity.Mail;
import com.will.user.control.UserRepository;
import com.will.user.entity.User;
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
            Mail mail = new Mail(userList, ingredientList);
            emitter.send(mail);
        }

        return Response.status(Response.Status.NOT_FOUND).build();

    }

}

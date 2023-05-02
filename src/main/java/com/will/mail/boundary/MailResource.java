package com.will.mail.boundary;

import com.will.mail.control.MailController;
import com.will.user.control.UserController;
import com.will.user.entity.UserRequest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/mail")
public class MailResource {

    @Inject
    MailController mailController;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendMail() {
        return mailController.sendMail();
    }
}

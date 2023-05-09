package com.will.user.exceptions;

import javax.json.bind.JsonbBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UserExceptionHandler implements ExceptionMapper<UserException> {

    @Override
    public Response toResponse(UserException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(JsonbBuilder.create().toJson(
                        new UserExceptionResponse(
                                e.getMessage(), e.getExceptionCode().getCode(), e.getExceptionCode().getFriendlyMessage()))).build();
    }
}

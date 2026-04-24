// LinkedResourceNotFoundExceptionMapper.java
package com.smartcampus.mapper;

import com.smartcampus.exception.LinkedResourceNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;

@Provider
public class LinkedResourceNotFoundExceptionMapper 
    implements ExceptionMapper<LinkedResourceNotFoundException> {
    @Override
    public Response toResponse(LinkedResourceNotFoundException e) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Unprocessable Entity");
        error.put("message", e.getMessage());
        return Response.status(422).entity(error).build();
    }
}
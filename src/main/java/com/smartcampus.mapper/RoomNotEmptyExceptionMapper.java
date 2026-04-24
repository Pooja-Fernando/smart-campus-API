// RoomNotEmptyExceptionMapper.java
package com.smartcampus.mapper;

import com.smartcampus.exception.RoomNotEmptyException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;

@Provider
public class RoomNotEmptyExceptionMapper 
    implements ExceptionMapper<RoomNotEmptyException> {
    @Override
    public Response toResponse(RoomNotEmptyException e) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Conflict");
        error.put("message", e.getMessage());
        return Response.status(409).entity(error).build();
    }
}
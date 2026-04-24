package com.smartcampus.resource;

import com.smartcampus.exception.LinkedResourceNotFoundException;
import com.smartcampus.model.Sensor;
import com.smartcampus.storage.DataStore;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/sensors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorResource {

    @GET
    public Response getSensors(@QueryParam("type") String type) {
        List<Sensor> sensorList = DataStore.getSensors().values().stream()
            .filter(s -> type == null || s.getType().equalsIgnoreCase(type))
            .collect(Collectors.toList());
        return Response.ok(sensorList).build();
    }

    @POST
    public Response createSensor(Sensor sensor) {
        if (!DataStore.getRooms().containsKey(sensor.getRoomId())) {
            throw new LinkedResourceNotFoundException(
                "Room " + sensor.getRoomId() + " not found."
            );
        }
        DataStore.getSensors().put(sensor.getId(), sensor);
        DataStore.getRooms().get(sensor.getRoomId())
            .getSensorIds().add(sensor.getId());
        return Response.status(201).entity(sensor).build();
    }

    @Path("/{sensorId}/readings")
    public SensorReadingResource getReadingResource(
            @PathParam("sensorId") String sensorId) {
        return new SensorReadingResource(sensorId);
    }
}
package ua.mateacademy.tania.lesson13.rest;


import ua.mateacademy.tania.lesson12.json.MateGroup;
import ua.mateacademy.tania.lesson12.json.Person;
import ua.mateacademy.tania.lesson12.json.Teacher;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Arrays;

import static javax.ws.rs.core.Response.Status.*;

/**
 * Created by Tania Nebesna on 29.01.2019.
 */
@Path("rs/mate")
public class MateGroupServiceImpl implements MateGroupService{
    private MateGroup mateGroup = MateGroup.mateGroupExampleCreator();

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMateGroup() {
        return Response.status(OK).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
    }

    @Override
    @PUT
    @Path("/{groupId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addStudent(@PathParam("groupId") int groupId, Person person) {
        if (groupId == mateGroup.getId()) {
            mateGroup.getStudents().addAll(Arrays.asList(person));
            return Response.status(ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(NOT_FOUND).build();
    }

    @Override
    @PUT
    @Path("/{groupId}/student")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStudent(@PathParam("groupId") int groupId, Person person) {
        if (person == null || groupId != mateGroup.getId()) {
            return Response.status(BAD_REQUEST).build();
        }
        for (Person student : mateGroup.getStudents()) {
            if (student.equals(person)) {
                student.update(person);
            }
        }
        return Response.status(ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
    }

    @Override
    @PUT
    @Path("/{groupId}/teacher")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTeacher(@PathParam("groupId") int groupId, Teacher teacher) {
        if (teacher == null || groupId != mateGroup.getId()) {
            return Response.status(BAD_REQUEST).build();
        }
        mateGroup.setTeacher(teacher);
        return Response.status(ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
    }
}

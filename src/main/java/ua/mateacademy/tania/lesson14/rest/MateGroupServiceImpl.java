package ua.mateacademy.tania.lesson14.rest;

import ua.mateacademy.tania.lesson12.json.HumanResource;
import ua.mateacademy.tania.lesson12.json.MateGroup;
import ua.mateacademy.tania.lesson12.json.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static javax.ws.rs.core.Response.Status.ACCEPTED;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.OK;

/**
 * Created by Tania Nebesna on 31.01.2019.
 */

@Path("/rs/mate/{groupId}")
public class MateGroupServiceImpl implements MateGroupService{
    private static Map<Integer, MateGroup> mateGroups = Arrays.asList(MateGroup.mateGroupExampleCreator()).stream()
            .collect(Collectors.toMap(MateGroup::getId, Function.identity()));

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMateGroup(@PathParam("groupId")int groupId) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            return Response.status(OK).entity(mateGroups.get(groupId)).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(NOT_FOUND).build();
    }

    @Override
    @PUT
    @Path("/students")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addStudent(@PathParam("groupId")int groupId, Person person) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup != null) {
            mateGroup.getStudents().addAll(Arrays.asList(person));
            return Response.status(ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(NOT_FOUND).build();
    }

    @Override
    @PUT
    @Path("/students/{surname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStudent(@PathParam("groupId")int groupId, @PathParam("surname")String surname,
                                  @QueryParam("name")String name) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup == null) {
            return Response.status(NOT_FOUND).build();
        }
        mateGroup.getStudents().stream().filter(student -> student.getSurname().equals(surname)).
                forEach(student -> student.setName(name));
        return Response.status(ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
    }

    @Override
    @DELETE
    @Path("/students/{surname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeStudent(@PathParam("groupId")int groupId, @PathParam("surname")String surname) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup == null) {
            return Response.status(NOT_FOUND).build();
        }
        mateGroup.getStudents().removeIf(student -> student.getSurname().equals(surname));
        return Response.status(ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
    }

    @Override
    @PUT
    @Path("/humanResource")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addHumanResource(@PathParam("groupId")int groupId, HumanResource humanResource) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup == null) {
            return Response.status(NOT_FOUND).build();
        }
        mateGroup.getHumanResources().add(humanResource);
        return Response.status(ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON_TYPE).build();
    }

    @Override
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/humanResource/{humanResourceId}")
    public Response removeHumanResourceById(@PathParam("groupId")int groupId, @PathParam("humanResourceId")int humanResourceId) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup == null) {
            return Response.status(NOT_FOUND).build();
        }
        mateGroup.getHumanResources().removeIf(hr -> hr.getId().equals(humanResourceId));
        return Response.status(ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
    }

    @Override
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/humanResource/{humanResourceId}")
    public Response editHRStartWorkYear(@PathParam("groupId")int groupId,  @PathParam("humanResourceId")int humanResourceId,
                                        @QueryParam("startWorkYear")int startWorkYear) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup == null) {
            return Response.status(NOT_FOUND).build();
        }
        mateGroup.getHumanResources().stream().filter(hm -> hm.getId().equals(humanResourceId)).
                forEach(hm -> hm.setStartWorkYear(startWorkYear));
        return Response.status(ACCEPTED).entity(mateGroup).type(MediaType.APPLICATION_JSON).build();
    }

    @Override
    @GET
    @Path("/humanResource")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllHumanResource(@PathParam("groupId")int groupId) {
        MateGroup mateGroup = mateGroups.get(groupId);
        if (mateGroup == null) {
            return Response.status(NOT_FOUND).build();
        }
        return Response.status(OK).entity(mateGroup.getHumanResources()).type(MediaType.APPLICATION_JSON).build();
    }

    @Override
    @GET
    @Path("/humanResource/{humanResourceId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHumanResourceById(@PathParam("groupId")int groupId, @PathParam("humanResourceId")int humanResourceId) {
        MateGroup mateGroup = mateGroups.get(groupId);
        HumanResource result;
        if (mateGroup != null) {
            Optional<HumanResource> optionalHR = mateGroup.getHumanResources().stream().
                    filter(hm -> hm.getId().equals(humanResourceId)).findFirst();

            if (optionalHR.isPresent()) {
                result = optionalHR.get();
                return Response.status(OK).entity(result).type(MediaType.APPLICATION_JSON).build();
            }
        }
        return Response.status(NOT_FOUND).build();
    }
}

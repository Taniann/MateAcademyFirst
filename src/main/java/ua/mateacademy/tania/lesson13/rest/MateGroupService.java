package ua.mateacademy.tania.lesson13.rest;

import ua.mateacademy.tania.lesson12.json.Person;

import javax.ws.rs.core.Response;

/**
 * Created by Tania Nebesna on 29.01.2019.
 */
public interface MateGroupService {
    public Response getMateGroup();

    public Response addStudent(int groupId, Person person);
}

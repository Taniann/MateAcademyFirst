package ua.mateacademy.tania.lesson14.rest;

import ua.mateacademy.tania.lesson12.json.HumanResource;
import ua.mateacademy.tania.lesson12.json.Person;

import javax.ws.rs.core.Response;

/**
 * Created by Tania Nebesna on 31.01.2019.
 */
public interface MateGroupService {
    Response getMateGroup(int groupId);

    Response addStudent(int groupId, Person person);

    Response updateStudent(int groupId, String surname, String name);

    Response removeStudent(int groupId, String surname);

    Response addHumanResource(int groupId, HumanResource humanResource);

    Response removeHumanResourceById(int groupId, int humanResourceId);

    Response editHRStartWorkYear(int groupId, int humanResourceId, int startWorkYear);

    Response getAllHumanResource(int groupId);

    Response getHumanResourceById(int groupId, int humanResourceId);
}


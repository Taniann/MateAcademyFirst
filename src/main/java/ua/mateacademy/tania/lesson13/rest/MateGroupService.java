package ua.mateacademy.tania.lesson13.rest;

import ua.mateacademy.tania.lesson12.json.Person;
import ua.mateacademy.tania.lesson12.json.Teacher;

import javax.ws.rs.core.Response;

/**
 * Created by Tania Nebesna on 29.01.2019.
 */
public interface MateGroupService {
    Response getMateGroup();

    Response addStudent(int groupId, Person person);

    Response updateStudent(int groupId, Person person);

    Response updateTeacher(int groupId, Teacher teacher);
}

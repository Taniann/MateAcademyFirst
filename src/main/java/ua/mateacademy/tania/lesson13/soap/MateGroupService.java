package ua.mateacademy.tania.lesson13.soap;

import ua.mateacademy.tania.lesson12.json.MateGroup;
import ua.mateacademy.tania.lesson12.json.Person;
import ua.mateacademy.tania.lesson12.json.Teacher;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

import static javax.jws.soap.SOAPBinding.Style.DOCUMENT;

/**
 * Created by Tania Nebesna on 29.01.2019.
 */
@WebService
@SOAPBinding(style = DOCUMENT)
public interface MateGroupService {
    @WebMethod
    MateGroup getMateGroup();

    @WebMethod
    MateGroup addStudents(List<Person> persons);

    @WebMethod
    MateGroup updateStudent(Person person);

    @WebMethod
    MateGroup updateTeacher(Teacher teacher);


}

package ua.mateacademy.tania.lesson13.soap;

import ua.mateacademy.tania.lesson12.json.MateGroup;
import ua.mateacademy.tania.lesson12.json.Person;
import ua.mateacademy.tania.lesson12.json.Teacher;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by Tania Nebesna on 29.01.2019.
 */
@WebService(endpointInterface = "ua.mateacademy.tania.lesson13.soap.MateGroupService")
public class MateGroupServiceImpl implements MateGroupService {
    private MateGroup mateGroup = MateGroup.mateGroupExampleCreator();

    @Override
    public MateGroup getMateGroup() {
        return mateGroup;
    }

    @Override
    public MateGroup addStudents(List<Person> persons) {
        mateGroup.getStudents().addAll(persons);
        return mateGroup;
    }

    @Override
    public MateGroup updateStudent(Person person) {
        for (Person student : mateGroup.getStudents()) {
            if (student.equals(person)) {
                student.update(person);
            }
        }
        return mateGroup;
    }

    @Override
    public MateGroup updateTeacher(Teacher teacher) {
        if (teacher != null) {
            mateGroup.setTeacher(teacher);
        }
        return mateGroup;
    }
}

package ua.mateacademy.tania.lesson13.soap;

import ua.mateacademy.tania.lesson12.json.Person;
import ua.mateacademy.tania.lesson12.json.Student;
import ua.mateacademy.tania.lesson12.json.Teacher;
import ua.mateacademy.tania.lesson13.soap.MateGroupService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tania Nebesna on 29.01.2019.
 */
public class MateGroupServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:9999/ws/mate?wsdl");

        // 1st argument service URI, refer to wsdl document above
        // 2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://soap.lesson13.tania.mateacademy.ua/", "MateGroupServiceImplService");

        Service service = Service.create(url, qname);

        MateGroupService hello = service.getPort(MateGroupService.class);

        System.out.println(hello.getMateGroup());

        List<Person> persons = new ArrayList<>();
        persons.add(new Student(8,"First", "First", 1995));
        persons.add(new Teacher(9,"Second", "Second", 1990, 666));
        System.out.println(hello.addStudents(persons));
        System.out.println(hello.updateStudent(new Student(2, "Name", "Surname", 1990)));
        System.out.println(hello.updateTeacher(new Teacher(2, "newTeacher", "Surname", 1990, 1000)));
    }
}

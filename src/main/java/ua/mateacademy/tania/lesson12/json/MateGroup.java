package ua.mateacademy.tania.lesson12.json;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tania Nebesna on 24.01.2019.
 */
@XmlRootElement(name = "MateGroup")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType (propOrder={"id", "room", "teacher", "students", "laptops", "humanResources"})
@JsonPropertyOrder({ "id", "room", "teacher", "students","laptops", "humanResources" })
public class MateGroup implements Serializable {

    @XmlElement(type = Teacher.class)
    private Person teacher;
    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
    @JsonSubTypes({ @JsonSubTypes.Type(value = Teacher.class, name = "teacher"),
            @JsonSubTypes.Type(value = Student.class, name = "student") })
    private List<Person> students;
    @XmlElement(required = true, nillable = false)
    private Room room;
    @XmlElementWrapper(name = "laptops")
    @XmlElement(name = "laptop")
    private List<Laptop> laptops;
    @XmlElementWrapper(name = "hrs")
    @XmlElement(name = "humanResource")
    private Set<HumanResource> humanResources;
    private int id;

    public MateGroup(Teacher teacher, List<Person> students, Room room, Set<HumanResource> humanResources) {
        this.teacher = teacher;
        this.students = students;
        this.room = room;
        this.humanResources = humanResources;
    }

    public MateGroup() {
    }

    public Person getTeacher() {
        return teacher;
    }

    @XmlElement
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Person> getStudents() {
        return students;
    }

    public void setStudents(List<Person> students) {
        this.students = students;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Set<HumanResource> getHumanResources() {
        return humanResources;
    }

    public void setHumanResources(Set<HumanResource> humanResources) {
        this.humanResources = humanResources;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "MateGroup [teacher=" + teacher + ", students=" + students + ", room=" + room + ", humanResources="
                + humanResources + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static MateGroup mateGroupExampleCreator() {
        MateGroup mateGroup = new MateGroup();
        mateGroup.setId(18122018);

        Teacher teacher = new Teacher("Serhii", "Pasko", 1988, 666);
        mateGroup.setTeacher(teacher);

        Room room = new Room("Kiyv", "Tarasivska", 16, 28);
        mateGroup.setRoom(room);

        Set<HumanResource> humanResources = new HashSet<>();
        humanResources.add(new HumanResource("Karmen", "", 1990, 2015));
        humanResources.add(new HumanResource("Efiria", "", 1989, 2016));
        mateGroup.setHumanResources(humanResources);

        List<Person> students = new ArrayList<>();
        students.add(new Student("Iza", "Rabinovish", 1997));
        students.add(new Student("Abram", "Kolom", 1998));
        students.add(new Teacher("Moisha", "Stefan", 1990, 666));
        mateGroup.setStudents(students);

        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("Dell", "Inspiron 15 3567", "USA"));
        laptops.add(new Laptop("HP", "250 G6", "USA"));
        mateGroup.setLaptops(laptops);


        return mateGroup;
    }
}
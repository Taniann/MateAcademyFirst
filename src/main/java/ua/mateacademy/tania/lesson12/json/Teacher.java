package ua.mateacademy.tania.lesson12.json;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Tania Nebesna on 24.01.2019.
 */
@XmlRootElement(name = "teacher")
public class Teacher extends Person {
    private int salary;

    public Teacher(Integer id, String name, String surname, int yearOfBorn, int salary) {
        super(id, name, surname, yearOfBorn);
        this.salary = salary;
    }

    public Teacher() {
        super();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher [salary=" + salary + " " + super.toString() + "]";
    }
}

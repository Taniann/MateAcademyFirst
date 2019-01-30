package ua.mateacademy.tania.lesson12.json;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Tania Nebesna on 24.01.2019.
 */
@XmlTransient
@XmlSeeAlso({ Student.class, Teacher.class, HumanResource.class })
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Person implements Serializable {
    private Integer id;
    private String name;
    private String surname;
    private int yearOfBorn;

    public Person() {
    }

    public Person(Integer id, String name, String surname, int yearOfBorn) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.yearOfBorn = yearOfBorn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYearOfBorn() {
        return yearOfBorn;
    }

    public void setYearOfBorn(int yearOfBorn) {
        this.yearOfBorn = yearOfBorn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", yearOfBorn=" + yearOfBorn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void update(Person person) {
        this.name = person.getName();
        this.surname = person.getSurname();
        this.yearOfBorn = person.getYearOfBorn();
    }
}

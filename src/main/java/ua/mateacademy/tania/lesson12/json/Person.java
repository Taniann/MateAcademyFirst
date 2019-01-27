package ua.mateacademy.tania.lesson12.json;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 * Created by Tania Nebesna on 24.01.2019.
 */
@XmlTransient
@XmlSeeAlso({ Student.class, Teacher.class, HumanResource.class })
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Person implements Serializable {
    private String name;
    private String surname;
    private int yearOfBorn;

    public Person() {
    }

    public Person(String name, String surname, int yearOfBorn) {
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

    @Override
    public String toString() {
        return "Person [name=" + name + ", surname=" + surname + ", yearOfBorn=" + yearOfBorn + "]";
    }

}

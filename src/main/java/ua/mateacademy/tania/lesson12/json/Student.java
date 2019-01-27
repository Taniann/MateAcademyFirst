package ua.mateacademy.tania.lesson12.json;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by Tania Nebesna on 24.01.2019.
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Student extends Person {

    @Override
    @XmlTransient
    @JsonIgnore
    public String getSurname() {
        return super.getSurname();
    }

    public Student() {

    }

    public Student(String name, String surname, int yearOfBorn) {
        super(name, surname, yearOfBorn);
    }

}

package ua.mateacademy.tania.builder;

import ua.mateacademy.tania.A;

/**
 * Created by Таня on 23.12.2018.
 */
public class Main {
    public static void main(String[] args) {
        Person person = Person.builder().withId(1).withName("name").withAge(20).build();
        System.out.println(person.toString());
        A a  = A.builder().setId(1).setName("Name").createA();
        System.out.println(a.toString());
    }
}

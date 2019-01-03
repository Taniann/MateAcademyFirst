package ua.mateacademy.tania.lesson5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Таня on 03.01.2019.
 */
public final class PersonImmutable {
    private int id;
    private String name;
    private int age;
   // Map<Integer, String> map = new HashMap<>();
    public PersonImmutable(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {

        PersonImmutable personImmutable = new PersonImmutable(1, "katia", 20);
    }

}

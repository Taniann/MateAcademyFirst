package ua.mateacademy.tania.lesson7;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by Tania Nebesna on 08.01.2019.
 */
public class Main {
    public static void main(String[] args) {
        Class<Animal> animalClass = Animal.class;

        Method[] methods = animalClass.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method);
        }

        Animal animal = new Animal("Cat", 5);

        try {
            Method method = animal.getClass().getDeclaredMethod("someInternalLogic");
            method.setAccessible(true);
            method.invoke(animal);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            ex.printStackTrace();
        }

        System.out.println(animal);

        // 2. З класу отримати список конструкторів і створити об'єкт за допомогою приватного конструктора
        Constructor[] constructors = animalClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(constructors));
        Animal animalFromPrivateConstr = null;

        constructors[1].setAccessible(true);
        try {
             animalFromPrivateConstr = (Animal) constructors[1].newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(animalFromPrivateConstr);
    }
}

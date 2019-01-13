package ua.mateacademy.tania.lesson7;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Tania Nebesna on 08.01.2019.
 */
@SuppressWarnings("unused")
public class Animal {
    private String name;
    private int old;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public Animal(String name, Integer old) {
        this.name = name;
        this.old = old;
    }

    private Animal() {
        name = "Unknown";
        old = -1;
    }

    @Override
    public String toString() {
        return "Animal [name=" + name + ", old=" + old + "]";
    }

    private void someInternalLogic() {
        old += 999;
        name += "!!!!";
    }

    public static<T> T  initiatePrivateConstructor(T clazz){
        T object = null;

        try {
            Class myClass = clazz.getClass();
            Constructor privateConstructor = myClass.getDeclaredConstructor();
            privateConstructor.setAccessible(true);
            object = (T) privateConstructor.newInstance();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return object;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Animal animal = new Animal("aa", 45);
        Constructor privateConstructor = Animal.class.getDeclaredConstructor(String.class, Integer.class);
        System.out.println(privateConstructor.toString());
        Animal youngAnimal = Animal.initiatePrivateConstructor(animal);
        System.out.println(youngAnimal.toString());
        AtomicInteger atomicInteger;
    }
}

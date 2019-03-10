package ua.mateacademy.tania.springintro.configuration;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.mateacademy.tania.springintro.Animal;
import ua.mateacademy.tania.springintro.entity.Cat;
import ua.mateacademy.tania.springintro.entity.Dog;
import ua.mateacademy.tania.springintro.entity.Mouse;

/**
 * Created by Tania Nebesna on 07.03.2019
 */
public class MainSpringApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Cat cat = context.getBean(Cat.class);
        System.out.println(cat);

        Dog dog = (Dog) context.getBean("dog");
        System.out.println(dog);

        Mouse mouse = context.getBean("mouse", Mouse.class);
        System.out.println(mouse);

        AppConfig.Pig pig1 = context.getBean("pig2", AppConfig.Pig.class);
        System.out.println(pig1);
        AppConfig.Pig pig2 = (AppConfig.Pig)context.getBean("pig", Animal.class);
        System.out.println(pig2);

        Animal animal = context.getBean(Animal.class);
        System.out.println(animal);
        context.close();
    }
}

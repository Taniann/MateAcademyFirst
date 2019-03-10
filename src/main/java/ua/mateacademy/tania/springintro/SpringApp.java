package ua.mateacademy.tania.springintro;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.mateacademy.tania.springintro.entity.Cat;
import ua.mateacademy.tania.springintro.entity.Dog;
import ua.mateacademy.tania.springintro.entity.Mouse;

/**
 * Created by Tania Nebesna on 07.03.2019
 */
public class SpringApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(
                "ua.mateacademy.tania.springintro.entity");

        Cat cat = context.getBean(Cat.class);
        System.out.println(cat);

        Dog dog = (Dog) context.getBean("dog");
        System.out.println(dog);

        Mouse mouse = context.getBean("mouse", Mouse.class);
        System.out.println(mouse);

        Animal animal = context.getBean("dog", Animal.class);
        System.out.println(animal);

        context.close();
    }
}

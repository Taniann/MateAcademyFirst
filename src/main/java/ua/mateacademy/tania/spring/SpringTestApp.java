package ua.mateacademy.tania.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.mateacademy.tania.spring.entity.*;

/**
 * Created by Tania Nebesna on 12.03.2019
 */
public class SpringTestApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(
                "ua.mateacademy.tania.spring");

/*        Pig pig = context.getBean(Pig.class);
        System.out.println(pig);

        Tiger tiger = context.getBean(Tiger.class);
        System.out.println(tiger);*/

        Kakadu kakadu = context.getBean(Kakadu.class);
        System.out.println(kakadu);

/*        Bloha bloha1 = context.getBean(Bloha.class);
        System.out.println(bloha1);

        Bloha bloha2 = context.getBean(Bloha.class);
        System.out.println(bloha2);

        Cat cat1 = context.getBean(Cat.class);
        System.out.println(cat1);

        Cat cat2 = context.getBean(Cat.class);
        System.out.println(cat2);*/

        context.close();
    }
}

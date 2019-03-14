package ua.mateacademy.tania.springintro.hw;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.mateacademy.tania.springintro.hw.entity.*;

/**
 * Created by Tania Nebesna on 10.03.2019
 */
public class SpringApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(
                "ua.mateacademy.tania.springintro.hw");

        Lily lily = context.getBean(Lily.class);
        System.out.println(lily);

        Rose rose1 = context.getBean(Rose.class);
        System.out.println(rose1);

        Rose rose2 = context.getBean(Rose.class);
        System.out.println(rose2);

        Violet violet = context.getBean(Violet.class);
        System.out.println(violet);

        context.close();
    }
}

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
                "ua.mateacademy.tania.springintro.hw.entity");

        Rose rose = context.getBean(Rose.class);
        System.out.println(rose);

        Flower poland = context.getBean("gerbera", Flower.class);
        System.out.println(poland);

        Chrysanthemum chrysanthemum = context.getBean("chrysanthemum", Chrysanthemum.class);
        System.out.println(chrysanthemum);

        Lily lily = (Lily) context.getBean("lily");
        lily.setColor("white");
        System.out.println(lily);

        Violet violet = context.getBean(Violet.class);
        System.out.println(violet);

        context.close();
    }
}

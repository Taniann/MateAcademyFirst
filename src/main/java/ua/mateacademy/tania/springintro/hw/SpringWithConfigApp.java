package ua.mateacademy.tania.springintro.hw;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.mateacademy.tania.springintro.hw.entity.Gerbera;
import ua.mateacademy.tania.springintro.hw.entity.Lily;
import ua.mateacademy.tania.springintro.hw.entity.Rose;

/**
 * Created by Tania Nebesna on 10.03.2019
 */
public class SpringWithConfigApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Rose rose = context.getBean(Rose.class);
        System.out.println(rose);

        Gerbera gerbera = (Gerbera) context.getBean("gerberabean");
        System.out.println(gerbera);

        Lily lily = context.getBean("lily", Lily.class);
        lily.setColor("white");
        System.out.println(lily);

        Lily lilybean = context.getBean("lilybean", Lily.class);
        System.out.println(lilybean);

        Flower flower = context.getBean(Flower.class);
        System.out.println(flower);
        context.close();
    }
}

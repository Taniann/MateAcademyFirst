package ua.mateacademy.tania.springintro.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ua.mateacademy.tania.springintro.AbstractAnimal;
import ua.mateacademy.tania.springintro.entity.Cat;
import ua.mateacademy.tania.springintro.entity.Dog;
import ua.mateacademy.tania.springintro.entity.Mouse;

/**
 * Created by Tania Nebesna on 07.03.2019
 */
@Configuration
@ComponentScan("ua.mateacademy.tania.springintro.entity")
public class AppConfig {

    @Bean
    public Cat returnCat() {
        return new Cat();
    }

    @Bean("dog")
    public Dog returnDog() {
        return new Dog();
    }

    @Bean("mouse")
    public Mouse returnMouse() {
        return new Mouse();
    }

    @Bean("pig")
    public Pig returnPig() {
        Pig pig = new Pig();
        pig.setColor("red");
        return pig;
    }

    @Component("pig2")
    //@Primary
    class Pig extends AbstractAnimal {
        private String color = "pink";

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String getVoice() {
            return "hru-hru";
        }

        @Override
        public String toString() {
            return "Pig{" + super.toString() +
                    " color='" + color + '\'' +
                    '}';
        }
    }
}

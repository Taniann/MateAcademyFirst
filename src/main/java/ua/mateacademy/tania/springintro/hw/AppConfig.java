package ua.mateacademy.tania.springintro.hw;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ua.mateacademy.tania.springintro.hw.entity.Gerbera;
import ua.mateacademy.tania.springintro.hw.entity.Lily;
import ua.mateacademy.tania.springintro.hw.entity.Rose;
import ua.mateacademy.tania.springintro.hw.entity.Violet;

/**
 * Created by Tania Nebesna on 10.03.2019
 */
@Configuration
@ComponentScan("ua.mateacademy.tania.springintro.hw.entity")
public class AppConfig {

    @Bean
    @Primary
    public Rose returnRose() {
        return new Rose();
    }

    @Bean("gerberabean")
    public Gerbera returnGerbera() {
        return new Gerbera();
    }

    @Bean("violetbean")
    public Violet returnMouse() {
        return new Violet();
    }

    @Bean("lilybean")
    public Lily returnLily() {
        Lily lily = new Lily();
        lily.setColor("red");
        return lily;
    }
}


package ua.mateacademy.tania.springintro.hw.entity;

import org.springframework.stereotype.Component;
import ua.mateacademy.tania.springintro.hw.Flower;

/**
 * Created by Tania Nebesna on 10.03.2019
 */
@Component("gerbera")
public class Gerbera extends Flower {
    @Override
    public String getColor() {
        return "red";
    }
}

package ua.mateacademy.tania.springintro.entity;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ua.mateacademy.tania.springintro.AbstractAnimal;

/**
 * Created by Tania Nebesna on 07.03.2019
 */
@Component
@Primary
public class Cat extends AbstractAnimal {
    @Override
    public String getVoice() {
        return "Mur-mur";
    }
}

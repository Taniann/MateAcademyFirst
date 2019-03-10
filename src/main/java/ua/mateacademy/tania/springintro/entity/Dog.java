package ua.mateacademy.tania.springintro.entity;

import org.springframework.stereotype.Component;
import ua.mateacademy.tania.springintro.AbstractAnimal;

/**
 * Created by Tania Nebesna on 07.03.2019
 */
@Component("dog")
public class Dog extends AbstractAnimal {
    @Override
    public String getVoice() {
        return "Gav-gav";
    }
}

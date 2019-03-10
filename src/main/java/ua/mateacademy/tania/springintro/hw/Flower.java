package ua.mateacademy.tania.springintro.hw;

import lombok.Data;

/**
 * Created by Tania Nebesna on 10.03.2019
 */
@Data
public abstract class Flower {
    private String name;
    private String color;

    public String getName() {
        return this.getClass().getSimpleName();
    }
}

package ua.mateacademy.tania.springintro.hw.entity;

import org.springframework.stereotype.Component;

/**
 * Created by Tania Nebesna on 10.03.2019
 */
@Component
public class Lily {
    private String color;

    public Lily() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Lily{" +
                "color='" + color + '\'' +
                '}';
    }
}

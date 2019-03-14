package ua.mateacademy.tania.springintro.hw.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Tania Nebesna on 10.03.2019
 */
@Component
public class Violet {
    private String color;

    private int price;

    public Violet(@Value("defaultColor")String color, @Value("50")int price) {
        this.color = color;
        this.price = price;
        System.out.println("In constructor" + this);
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Violet{" +
                "color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    @PostConstruct
    private void init() {
        color = "colorFromPostConstr";
        System.out.println("In post constructor " + this);
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("In preDestroy method." + this + "will be died");
    }
}

package ua.mateacademy.tania.springintro.hw.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by Tania Nebesna on 10.03.2019
 */
@Component
@DependsOn("lily")
@PropertySource("spring/rose.properties")
public class Rose {
    @Value("${color:default color}")
    private String color;

    @Autowired
    private Lily lily;

    @Autowired
    private Leaf leaf;

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Rose{" +
                "color='" + color + '\'' +
                ", lily=" + lily +
                ", leaf=" + leaf +
                '}';
    }
}

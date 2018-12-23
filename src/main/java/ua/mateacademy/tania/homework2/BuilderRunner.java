package ua.mateacademy.tania.homework2;

import java.math.BigDecimal;

/**
 * Created by Таня on 23.12.2018.
 */
public class BuilderRunner {
    public static void main(String[] args) {
        Edition edition = Edition.builder().
                withId(1).
                withName("Piznayko").
                withInfo("magazine for children").
                withPrice(new BigDecimal(25.5)).
                withType("printed").build();
        System.out.println(edition.toString());
    }
}

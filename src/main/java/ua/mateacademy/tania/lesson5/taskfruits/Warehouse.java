package ua.mateacademy.tania.lesson5.taskfruits;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

/**
 * Created by Tania Nebesna on 04.01.2019.
 */
public final class Warehouse {
    public static Fruit apples1 = new Fruit(FruitKind.APPLE, 30,
            LocalDate.of(2018, Month.DECEMBER, 20), BigDecimal.valueOf(15.5));
    public static Fruit apples2 = new Fruit(FruitKind.APPLE, 35,
            LocalDate.of(2019, Month.JANUARY, 2), BigDecimal.valueOf(19.5));
    public static Fruit pears = new Fruit(FruitKind.PEAR, 20,
            LocalDate.of(2018, Month.DECEMBER, 20), BigDecimal.valueOf(30));
    public static Fruit oranges = new Fruit(FruitKind.ORANGE, 40,
            LocalDate.of(2019, Month.JANUARY, 2), BigDecimal.valueOf(32.5));
    public static Fruit bananas = new Fruit(FruitKind.BANANA, 40,
            LocalDate.of(2018, Month.DECEMBER, 20), BigDecimal.valueOf(22));
    public static Fruit grapes1 = new Fruit(FruitKind.GRAPES, 15,
            LocalDate.of(2018, Month.DECEMBER, 25), BigDecimal.valueOf(45));
    public static Fruit grapes2 = new Fruit(FruitKind.GRAPES, 15,
            LocalDate.of(2018, Month.DECEMBER, 25), BigDecimal.valueOf(20));

    private Warehouse() {
    }
}

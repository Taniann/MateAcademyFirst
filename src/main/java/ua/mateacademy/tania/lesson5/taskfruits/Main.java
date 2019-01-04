package ua.mateacademy.tania.lesson5.taskfruits;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tania Nebesna on 04.01.2019.
 */
public class Main {
    private static final int DAYS_FOR_SALE = 7;
    private static final BigDecimal MULTIPLIER_FOR_SALE = BigDecimal.valueOf(0.75);
    public static void main(String[] args) {
        Shop shop = new Shop();

        shop.addFruit(Warehouse.apples1);
        shop.addFruit(Warehouse.apples2);
        shop.addFruit(Warehouse.pears);
        shop.addFruit(Warehouse.oranges);
        shop.addFruit(Warehouse.bananas);
        shop.addFruit(Warehouse.grapes1);
        shop.addFruit(Warehouse.grapes2);

        List<Fruit> freshFruits = shop.getFreshFruitsWithLambda(LocalDate.of(2018, Month.DECEMBER, 20));
        System.out.println(freshFruits);

        List<Fruit> fruitsApple = shop.getFruitsByKind(FruitKind.APPLE);
        System.out.println(fruitsApple);

        List<Fruit> fruitsByExpirationDate = shop.getFruitsByExpirationDate(25);
        System.out.println(fruitsByExpirationDate);

        List<Fruit> freshFruitsByKind = shop.getFreshFruitsByKind
                (FruitKind.GRAPES, LocalDate.of(2018, Month.DECEMBER, 20) );
        System.out.println(freshFruitsByKind);

        List<Fruit> fruitsWithSale = shop.makeSale(Arrays.asList(FruitKind.APPLE, FruitKind.GRAPES), DAYS_FOR_SALE, MULTIPLIER_FOR_SALE);
        System.out.println(fruitsWithSale);
        System.out.println(shop.getFruits());

        System.out.println(Warehouse.pears.getKind().getName());
        System.out.println(Warehouse.bananas.getKind().getName());

    }
}

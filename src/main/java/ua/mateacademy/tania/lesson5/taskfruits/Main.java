package ua.mateacademy.tania.lesson5.taskfruits;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tania Nebesna on 04.01.2019.
 */
public class Main {
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

        shop.makeSale(Arrays.asList(FruitKind.APPLE, FruitKind.GRAPES));
        System.out.println(shop.getFruits());
    }
}

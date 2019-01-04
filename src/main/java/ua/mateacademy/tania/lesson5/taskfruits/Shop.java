package ua.mateacademy.tania.lesson5.taskfruits;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Created by Tania Nebesna on 04.01.2019.
 */
public class Shop {
    private List<Fruit> fruits = new ArrayList<>();

    public  List<Fruit> getFruits() {
        return fruits;
    }

    public void addFruit(Fruit fruit) {
            fruits.add(fruit);
    }

    public List<Fruit> getFreshFruits(LocalDate date) {
        List<Fruit> result = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if(fruit.getDeliveryDate().isAfter(date)) {
                result.add(fruit);
            }
        }
        return result;
    }

    public List<Fruit> getFreshFruitsWithLambda(LocalDate date) {
     return fruits.stream().filter(fruit -> fruit.getDeliveryDate().isAfter(date)).collect(Collectors.toList());
    }

    public List<Fruit> getFruitsByKind(FruitKind kind) {
        return fruits.stream().filter(fruit -> fruit.getKind().equals(kind)).collect(Collectors.toList());
    }

    public List<Fruit> getFruitsByExpirationDate(int days) {
        return fruits.stream().filter(fruit -> fruit.getExpirationDate() > days).collect(Collectors.toList());
    }

    public List<Fruit> getFreshFruitsByKind(FruitKind kind, LocalDate date) {
        return fruits.stream().
                filter(fruit -> fruit.getKind().equals(kind) && fruit.getDeliveryDate().isAfter(date)).
                collect(Collectors.toList());
    }

    /**
     * method makes sale for transfered kinds of fruits,
     * if expiration date less than 7 days
     * the price of fruit will be reduced by 25 percent
     * @param kinds
    */
    public List<Fruit> makeSale(List<FruitKind> kinds, int daysForSale, BigDecimal multiplierForSale) {
        LocalDate now = LocalDate.now();
        List<Fruit> result;
        result = fruits.stream().
                filter(fruit -> kinds.contains(fruit.getKind()) && fruit.getExpirationDate() - DAYS.between(fruit.getDeliveryDate(), now) <= daysForSale).
                collect(Collectors.toList());

        result.forEach(fruit -> fruit.setPrice(fruit.getPrice().multiply(multiplierForSale)));
        return result;
    }
}



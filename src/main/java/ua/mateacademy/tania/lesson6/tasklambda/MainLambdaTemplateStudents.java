package ua.mateacademy.tania.lesson6.tasklambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


import static ua.mateacademy.tania.lesson6.tasklambda.FruitType.*;
import static ua.mateacademy.tania.lesson6.tasklambda.Vitamins.*;

/**
 * Created by Tania Nebesna on 05.01.2019.
 */
public class MainLambdaTemplateStudents {
    public static void main(String[] args) {
        List<Fruit> fruits = fillFruitsList();
        fruits.forEach(System.out::println);
        //System.out.println(fruits.stream().filter(fruit -> fruit.getFruitType().equals(PEAR)).collect(Collectors.toList()));
        System.out.println("____________________");
        fruits.stream().filter(fruit -> fruit.getFruitType().equals(PEAR)).forEach(System.out::println);

        System.out.println("____________________");
        fruits.stream().skip(4).forEach(System.out::println);

        System.out.println("____________________");
        fruits.stream().distinct().forEach(System.out::println);

        System.out.println("____________________");
        fruits.stream().map(fruit -> fruit.getFruitType() + " " + fruit.getPrice()).forEach(System.out::println);

        System.out.println("____________________");
        fruits.stream().map(Fruit::getFruitType).forEach(System.out::println);

        System.out.println("____________________");
        fruits.stream().map(Fruit::getFruitTypeAndPrice).forEach(System.out::println);

        System.out.println("____________________");
        fruits.stream().peek(System.out::println).map(Fruit::getFruitTypeAndPrice).forEach(System.out::println);

        System.out.println("____________________");
        fruits.stream().limit(4).forEach(System.out::println);

        System.out.println("____________________");
        Comparator<Fruit> fruitComparator = new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                int result = o1.getFruitType().toString().compareTo(o2.getFruitType().toString());

                if(result == 0) {
                    result = o1.getPrice() - o2.getPrice();
                }
                return result;
            }
        };

        fruits.stream().sorted(fruitComparator).forEach(System.out::println);

        System.out.println("____________________");
        fruits.stream().mapToDouble(Fruit::getPrice).forEach(System.out::println);

        System.out.println("____________________");
        fruits.stream().flatMap(fruit -> Stream.of(fruit.getFruitType().toString().toCharArray()).peek(System.out::println)).toArray();

        System.out.println("____________________");
        fruits.stream().findFirst().ifPresent(System.out::println);

        System.out.println("____________________");
        fruits.stream().findAny().ifPresent(System.out::println);

        System.out.println("____________________");
        System.out.println(fruits.stream().filter(fruit -> fruit.getFruitType().equals(APPLE)).count());

        System.out.println("____________________");
        System.out.println(fruits.stream().anyMatch(fruit -> fruit.getFruitType().equals(APPLE)));

        System.out.println("____________________");
        System.out.println(fruits.stream().noneMatch(fruit -> fruit.getFruitType().equals(APPLE)));

        System.out.println("____________________");
        System.out.println(fruits.stream().allMatch(fruit -> fruit.getFruitType().equals(APPLE)));

        System.out.println("____________________");
        System.out.println(fruits.stream().min(Comparator.comparingInt(Fruit::getPrice)).get());

        System.out.println("____________________");
        System.out.println(fruits.stream().max(Comparator.comparingInt(Fruit::getPrice)).get());

        System.out.println("____________________");
        fruits.forEach(fruit -> fruit.setPrice(fruit.getPrice() + 10));
        fruits.stream().forEachOrdered(System.out::println);

        System.out.println("____________________");
        Fruit[] array = fruits.stream().toArray(Fruit[]::new);
        Arrays.stream(array).forEach(System.out::println);

        System.out.println("____________________");
        System.out.println(fruits.stream().mapToInt(Fruit::getPrice).reduce((p1, p2) -> p1 + p2).orElse(0));
    }

    private static List<Fruit> fillFruitsList() {
        List<Fruit> fruits = new ArrayList<>();

        Fruit fruit = new Fruit(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { B, C }));
        fruits.add(fruit);

        fruit = new Fruit(STRAWBERRY, 15, LocalDate.of(2019, 1, 2), 50, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { A, C }));
        fruits.add(fruit);

        fruit = new Fruit(PEAR, 30, LocalDate.of(2019, 1, 4), 40, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { A, B1, B2, C }));
        fruits.add(fruit);

        fruit = new Fruit(ORANGE, 60, LocalDate.of(2019, 1, 3), 30, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { E, B, A }));
        fruits.add(fruit);

        fruit = new Fruit(STRAWBERRY, 25, LocalDate.of(2019, 1, 2), 60, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { A, C, D }));
        fruits.add(fruit);

        fruit = new Fruit(PEAR, 15, LocalDate.of(2019, 1, 4), 40, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { A, B, B1, B2, P }));
        fruits.add(fruit);

        fruit = new Fruit(PEAR, 5, LocalDate.of(2019, 1, 6), 10, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { B1, B2, P }));
        fruits.add(fruit);

        fruit = new Fruit(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { B, C }));
        fruits.add(fruit);

        return fruits;
    }

}

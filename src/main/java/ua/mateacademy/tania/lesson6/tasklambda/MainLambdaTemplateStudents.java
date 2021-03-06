package ua.mateacademy.tania.lesson6.tasklambda;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static java.util.stream.Collectors.*;
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

        System.out.println("____________________");
        System.out.println(fruits.stream().map(Fruit::getVitamins).distinct().collect(Collectors.toList()));

        System.out.println("____________________");
        System.out.println(fruits.stream().flatMap(fruit -> fruit.getVitamins().stream()).distinct().collect(Collectors.toList()));

        Collection<LocalDate> localDates = fruits.stream().map(Fruit::getDeliveryDate).collect(toCollection(ArrayDeque::new));
        System.out.println(localDates);

        Map<Integer, Fruit> fruitMap = fruits.stream().collect(toMap(Fruit::getPrice, Function.identity(), (f1, f2) -> f1));

        for(Map.Entry<Integer, Fruit> fruit : fruitMap.entrySet()) {
            System.out.println(fruit.getKey() + " " + fruit.getValue());
        }

        System.out.println("____________________");
        String str = fruits.stream().map(fruit -> fruit.getFruitType().toString()).distinct().
                collect(joining(", ", "[", "]"));
        System.out.println(str);

        Map<FruitType, List<Fruit>> map = fruits.stream().collect(groupingBy(Fruit::getFruitType));

        // 1. Зробити глибоке клонування List<Fruit> за допомогою сереалізації
        System.out.println("____________________");
        List<Fruit> fruitsClone = new ArrayList<>();
        try {
             fruitsClone = deepCloneFruits(fruits);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        fruitsClone.stream().forEach(fruit -> fruit.setPrice(0));
        fruitsClone.forEach(System.out::println);
        System.out.println("____________________");
        fruits.forEach(System.out::println);

        //3. Зробити методи в класі фрукт що вертають checkable|unchecable exceptions  і їх обробляти
        try {
            fruits.get(0).dividePrice(0);
        }catch (ArithmeticException ex) {
            System.out.println("You`ve done uncorrect arithmetic operation!");
        }

        Fruit.openSomeFile("non-existence file");
    }

    private static List<Fruit> fillFruitsList() {
        List<Fruit> fruits = new ArrayList<>();

        Fruit fruit = new Fruit(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { B, C , C}));
        fruits.add(fruit);

        fruit = new Fruit(STRAWBERRY, 15, LocalDate.of(2019, 1, 2), 50, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { A, C, A }));
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


    // 1. Зробити глибоке клонування List<Fruit> за допомогою сереалізації
    public static List<Fruit> deepCloneFruits(List<Fruit> fruits) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous = new ObjectOutputStream(baos);

        ous.writeObject(fruits);
        ous.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);

        List<Fruit> result = (List<Fruit>) ois.readObject();

        return result;
    }


}

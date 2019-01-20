package ua.mateacademy.tania.lesson10;

import org.junit.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ua.mateacademy.tania.lesson10.FruitType.*;
import static ua.mateacademy.tania.lesson10.Vitamins.*;

/**
 * Created by Tania Nebesna on 17.01.2019.
 */
public class FruitShopUnitTest {
    private static FruitShop fruitShop;
    private static Fruit strawberry;
    private static Fruit apple;
    private static Fruit pear;
    private static Fruit orange;
    private static Fruit appleGrenni;


    @BeforeClass
    public static void beforeClass() {
        System.out.println("before class");
        strawberry = new Fruit(STRAWBERRY, 40,
                LocalDate.of(2019, Month.JANUARY, 1), 45, Arrays.asList(B, C, A));
        apple = new Fruit(APPLE, 30,
                LocalDate.of(2019, Month.DECEMBER, 20), 15, Arrays.asList(B, C, A));
        pear = new Fruit(PEAR, 30,
                LocalDate.of(2018, Month.DECEMBER, 25), 25, Arrays.asList(B, C, A));
        orange = new Fruit(ORANGE, 30,
                LocalDate.of(2018, Month.DECEMBER, 15), 15, Arrays.asList(B, C));
        appleGrenni = new Fruit(APPLE, 30,
                LocalDate.of(2019, Month.DECEMBER, 20), 25, Arrays.asList(B, C));
        List<Fruit> fruits = Arrays.asList(strawberry, apple, pear, orange, appleGrenni);
        fruitShop = new FruitShop("Fruit Shop", fruits);

    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class");
    }

    @Test
    public void testAllFresh() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(pear);
        expected.add(orange);
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2018, Month.DECEMBER, 31));
        assertEquals(expected, actual);
    }

    @Test
    public void testAllFreshShoudBeEmpty() {
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2020, Month.DECEMBER, 31));
        assertTrue(actual.size() == 0);
    }

    @Test(expected = NullPointerException.class)
    public void testAllFreshThrowsNullPointerException() {
        fruitShop.allFresh(null);
    }

    @Test
    public void testAllFruitOfFruitType() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(apple);
        expected.add(appleGrenni);
        List<Fruit> actual = fruitShop.allFruitOfFruitType(APPLE);
        assertEquals(expected, actual);
    }

    @Test
    public void testAllFruitOfFruitTypeShouldBeEmpty() {
        List<Fruit> listWithoutApple = new ArrayList<>();
        listWithoutApple.add(strawberry);
        listWithoutApple.add(orange);
        FruitShop fruitShop = new FruitShop("new fruit shop", listWithoutApple);
        List<Fruit> actual = fruitShop.allFruitOfFruitType(APPLE);
        assertTrue(actual.size() == 0);
    }

    @Test
    public void testCheckByExpireDate() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(strawberry);
        List<Fruit> actual = fruitShop.checkByExpireDate(30);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckByExpireDateShouldBeEmpty() {
        List<Fruit> actual = fruitShop.checkByExpireDate(40);
        assertTrue(actual.size() == 0);
    }

    @Test
    public void testAllFreshAndFruitType() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(apple);
        expected.add(appleGrenni);
        List<Fruit> actual = fruitShop.allFreshAndFruitType(APPLE, LocalDate.of(2019, Month.DECEMBER, 31));
        assertEquals(expected, actual);
    }

    @Test
    public void testAllFreshAndFruitTypeShouldBeEmpty() {
        List<Fruit> actual = fruitShop.allFreshAndFruitType(STRAWBERRY, LocalDate.of(2019, Month.DECEMBER, 31));
        assertTrue(actual.size() == 0);
    }

    @Test(expected = NullPointerException.class)
    public void testAllFreshAndFruitTypeThrowsNullPointerException() {
        fruitShop.allFreshAndFruitType(APPLE, null);
    }

    @Test
    public void testReSetPricexRealization() {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(apple);
        fruits.add(pear);
        fruits.add(orange);
        List<Fruit> actual = fruitShop.reSetPricexRealization(50, 40, ORANGE, PEAR);
        assertEquals(pear.getPrice() / 2, actual.get(0).getPrice());
        assertEquals(orange.getPrice() / 2, actual.get(1).getPrice());
    }

    @Test
    public void testReSetPricexRealizationShouldBeEmpty() {
        List<Fruit> actual = fruitShop.reSetPricexRealization(50, 10, ORANGE, PEAR);
        assertTrue(actual.size() == 0);
    }

    @Test(expected = NullPointerException.class)
    public void testReSetPricexRealizationThrowsNullPointerException() {
        fruitShop.reSetPricexRealization(50, 10, null);
    }
}
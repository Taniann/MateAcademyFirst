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
public class FruitShopUnitTest{
    private static FruitShop fruitShop;
    private static Fruit strawberry;
    private static Fruit apple;
    private static Fruit pear;
    private static Fruit orange;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("before class");
        strawberry = new Fruit(STRAWBERRY, 40,
                LocalDate.of(2019, Month.JANUARY, 1), 45, Arrays.asList(B, C, A));
        apple = new Fruit(APPLE, 30,
                LocalDate.of(2018, Month.DECEMBER, 20), 15, Arrays.asList(B, C, A));
        pear = new Fruit(PEAR, 30,
                LocalDate.of(2018, Month.DECEMBER, 25), 25, Arrays.asList(B, C, A));
        orange = new Fruit(ORANGE, 30,
                LocalDate.of(2018, Month.DECEMBER, 15), 15, Arrays.asList(B, C));
        List<Fruit> fruits = Arrays.asList(strawberry, apple, pear, orange);
        fruitShop = new FruitShop("Fruit Shop", fruits);

    }

    @AfterClass
    public static void afterClass() {
    }

    @Test
    public void testAllFresh() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(apple);
        expected.add(pear);
        expected.add(orange);
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2018, Month.DECEMBER, 31));
        assertEquals(expected, actual);
    }

    @Test
    public void testAllFreshShoudBeNull() {
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019, Month.DECEMBER, 31));
        assertTrue(actual.size() == 0);
    }

    @Test(expected = NullPointerException.class)
    public void testAllFreshThroswNullPointerException() {
        fruitShop.allFresh(null);
    }

    @Test
    public void testAllFruitOfFruitType() {
    }

    @Test
    public void testCheckByExpireDate() {
    }

    @Test
    public void testAllFreshAndFruitType() {
    }

    @Test
    public void testReSetPricexRealization() {
    }
}
package ua.mateacademy.tania.lesson10;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static ua.mateacademy.tania.lesson10.FruitType.*;

/**
 * Created by Tania Nebesna on 23.01.2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class FruitShopMockSpyTest {
    @Spy
    @InjectMocks
    private FruitShop fruitShop;

    @Mock
    private Fruit strawberry;
    @Mock
    private Fruit apple;
    @Mock
    private Fruit pear;
    @Mock
    private Fruit orange;

    @Before
    public void setUp() {
        when(strawberry.getFruitType()).thenReturn(STRAWBERRY);
        createFruitMock(strawberry, 40, LocalDate.of(2019, Month.JANUARY, 1), 45);

        when(apple.getFruitType()).thenReturn(APPLE);
        createFruitMock(apple, 30, LocalDate.of(2019, Month.DECEMBER, 20), 15);

        when(pear.getFruitType()).thenReturn(PEAR);
        createFruitMock(pear, 30, LocalDate.of(2018, Month.DECEMBER, 25), 25);

        when(orange.getFruitType()).thenReturn(ORANGE);
        createFruitMock(orange, 30,
                LocalDate.of(2018, Month.DECEMBER, 15), 25);

        doReturn(Arrays.asList(strawberry, apple, pear, orange)).when(fruitShop).getFruits();
    }

    private void createFruitMock(Fruit fruit, int dayToLive, LocalDate deliveryDate, int price) {
        when(fruit.getDayToLive()).thenReturn(dayToLive);
        when(fruit.getDeliveryDate()).thenReturn(deliveryDate);
        when(fruit.getPrice()).thenReturn(price);
        when(fruit.clone()).thenReturn(fruit);
    }

    @Test
    public void testAllFresh() {
        List<Fruit> expected = Arrays.asList(pear, orange);
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2018, Month.DECEMBER, 31));
        assertEquals(expected, actual);
    }

    @Test
    public void testAllFreshShouldBeEmpty() {
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2020, Month.DECEMBER, 31));
        assertTrue(actual.size() == 0);
    }

    @Test
    public void testAllFreshWithVerify() {
        fruitShop.allFresh(LocalDate.of(2018, Month.DECEMBER, 31));
        verify(fruitShop, times(1)).getFruits();
        verify(strawberry, times(1)).getDayToLive();
        verify(strawberry, times(1)).getDeliveryDate();
    }

    @Test
    public void testAllFruitOfFruitType() {
        List<Fruit> expected = Arrays.asList(pear);
        List<Fruit> actual = fruitShop.allFruitOfFruitType(PEAR);
        assertEquals(expected, actual);
    }

    @Test
    public void testAllFruitOfFruitTypeWithVerify() {
        fruitShop.allFruitOfFruitType(PEAR);
        verify(fruitShop, times(1)).getFruits();
        verify(strawberry, times(1)).getFruitType();
        verify(pear, times(1)).getFruitType();
    }

    @Test
    public void testCheckByExpireDate() {
        doReturn(Arrays.asList(strawberry)).when(fruitShop).checkByExpireDate(30);
        List<Fruit> expected = Arrays.asList(strawberry);
        List<Fruit> actual = fruitShop.checkByExpireDate(30);
        assertEquals(expected, actual);
    }

    @Test
    public void testAllFreshAndFruitType() {
        doReturn(Arrays.asList(apple)).when(fruitShop).allFreshAndFruitType(APPLE,
                LocalDate.of(2019, Month.DECEMBER, 31));
        List<Fruit> expected = Arrays.asList(apple);
        List<Fruit> actual = fruitShop.allFreshAndFruitType(APPLE,
                LocalDate.of(2019, Month.DECEMBER, 31));
        assertEquals(expected, actual);
    }

    @Test
    public void testReSetPricexRealization() {
        fruitShop.reSetPricexRealization(50, 40, ORANGE, PEAR);
        verify(fruitShop, times(1)).getFruits();
        verify(orange, times(1)).getPrice();
        verify(pear, times(1)).getPrice();
    }
}
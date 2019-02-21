package ua.mateacademy.tania.patterns.decorator;

import java.math.BigDecimal;

public class DecoratorPatternApp {
    public static void main(String[] args) {
        Product laptop = new Laptop(new BigDecimal(15000));
        laptop = new PriceDiscountDecorator(50, laptop);
        System.out.println(laptop.getPrice()); // output: 7500
    }
}

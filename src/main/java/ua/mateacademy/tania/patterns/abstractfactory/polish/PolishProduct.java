package ua.mateacademy.tania.patterns.abstractfactory.polish;

import ua.mateacademy.tania.patterns.abstractfactory.Product;

public class PolishProduct implements Product {
    @Override
    public void printDescription() {
        System.out.println("some polish product");
    }
}

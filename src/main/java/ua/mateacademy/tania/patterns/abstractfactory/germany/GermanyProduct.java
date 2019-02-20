package ua.mateacademy.tania.patterns.abstractfactory.germany;

import ua.mateacademy.tania.patterns.abstractfactory.Product;

public class GermanyProduct implements Product {
    @Override
    public void printDescription() {
        System.out.println("some germany product");
    }
}

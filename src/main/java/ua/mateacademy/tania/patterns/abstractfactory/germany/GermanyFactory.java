package ua.mateacademy.tania.patterns.abstractfactory.germany;

import ua.mateacademy.tania.patterns.abstractfactory.Factory;
import ua.mateacademy.tania.patterns.abstractfactory.Instruction;
import ua.mateacademy.tania.patterns.abstractfactory.Product;

public class GermanyFactory implements Factory {
    @Override
    public Product createProduct() {
        return new GermanyProduct();
    }

    @Override
    public Instruction createInstruction() {
        return new GermanyInstruction();
    }
}

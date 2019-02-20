package ua.mateacademy.tania.patterns.abstractfactory.polish;

import ua.mateacademy.tania.patterns.abstractfactory.Factory;
import ua.mateacademy.tania.patterns.abstractfactory.Instruction;
import ua.mateacademy.tania.patterns.abstractfactory.Product;

public class PolishFactory implements Factory {
    @Override
    public Product createProduct() {
        return new PolishProduct();
    }

    @Override
    public Instruction createInstruction() {
        return new PolishInstruction();
    }
}

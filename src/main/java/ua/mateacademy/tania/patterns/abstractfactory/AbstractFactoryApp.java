package ua.mateacademy.tania.patterns.abstractfactory;

import ua.mateacademy.tania.patterns.abstractfactory.polish.PolishFactory;

public class AbstractFactoryApp {
    public static void main(String[] args) {
        Factory factory = new PolishFactory();

        Product product = factory.createProduct();
        Instruction instruction = factory.createInstruction();

        product.printDescription();
        instruction.printContent();
    }
}

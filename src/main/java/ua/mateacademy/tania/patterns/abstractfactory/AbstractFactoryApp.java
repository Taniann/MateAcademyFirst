package ua.mateacademy.tania.patterns.abstractfactory;

public class AbstractFactoryApp {
    public static void main(String[] args) {
        Factory factory = FactoryProvider.getFactory("Polish");

        Product product = factory.createProduct();
        Instruction instruction = factory.createInstruction();

        product.printDescription();
        instruction.printContent();
    }
}

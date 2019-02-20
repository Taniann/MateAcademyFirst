package ua.mateacademy.tania.patterns.abstractfactory.polish;

import ua.mateacademy.tania.patterns.abstractfactory.Instruction;

public class PolishInstruction implements Instruction {
    @Override
    public void printContent() {
        System.out.println("instruction for some polish product");
    }
}

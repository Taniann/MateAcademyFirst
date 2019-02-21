package ua.mateacademy.tania.patterns.abstractfactory.germany;

import ua.mateacademy.tania.patterns.abstractfactory.Instruction;

public class GermanyInstruction implements Instruction {
    @Override
    public void printContent() {
        System.out.println("instruction for some germany product");
    }
}

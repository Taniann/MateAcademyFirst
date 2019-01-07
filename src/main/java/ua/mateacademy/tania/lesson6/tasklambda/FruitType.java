package ua.mateacademy.tania.lesson6.tasklambda;

/**
 * Created by Tania Nebesna on 05.01.2019.
 */
public enum FruitType {
    STRAWBERRY("Strawberry"), APPLE("Apple"), PEAR("Pear"), ORANGE("Orange");

    FruitType(String name) {
        this.name = name;
    }

    private String name;

    public String toString() {
        return name;
    }
}

package ua.mateacademy.tania.lesson10;

/**
 * Created by Tania Nebesna on 17.01.2019.
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

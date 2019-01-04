package ua.mateacademy.tania.lesson5.taskfruits;

/**
 * Created by Tania Nebesna on 04.01.2019.
 */
public enum FruitKind{
    APPLE("grenni"),
    PEAR("bera"),
    ORANGE(""),
    BANANA(""),
    GRAPES("kysh-mysh");

    FruitKind(String name) {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }
}

package ua.mateacademy.tania.lesson9.semaphore;

/**
 * Created by Tania Nebesna on 15.01.2019.
 */
public class CommonResource {
    private int value;

    public CommonResource(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void incrementValue() {
        value++;
    }
}

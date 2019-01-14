package ua.mateacademy.tania.lesson8.homework8.synchronizedexample;

/**
 * Created by Tania Nebesna on 14.01.2019.
 */
public class TransferObject {
    private int value;
    private volatile boolean isValuePresent = false;

    public synchronized int get() {
        while (!isValuePresent)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println("Got: " + value);
        isValuePresent = false;
        notify();
        return value;
    }

    public synchronized void put(int value) {
        while (isValuePresent) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.value = value;
        System.out.println("Put: " + value);
        isValuePresent = true;
        notify();
    }
}

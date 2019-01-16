package ua.mateacademy.tania.lesson9.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Tania Nebesna on 15.01.2019.
 */
public class CountThread implements Runnable{
    private AtomicInteger value;
    private String name;

    public CountThread(String name, AtomicInteger value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " waiting");
            for (int i = 0; i < 5; i++) {
                value.incrementAndGet();
                System.out.println(name + ": " + value.get());
                Thread.sleep(100);
            }
        }catch (InterruptedException ex) {
        }
    }
}

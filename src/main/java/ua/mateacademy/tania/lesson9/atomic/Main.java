package ua.mateacademy.tania.lesson9.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Tania Nebesna on 15.01.2019.
 */
public class Main {
    public static void main(String[] args) {
        AtomicInteger value = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Thread thread1 = new Thread(new CountThread("thread-1", value));
        Thread thread2 = new Thread(new CountThread("thread-2", value));
        Thread thread3 = new Thread(new CountThread("thread-3", value));
        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.execute(thread3);

        executorService.shutdown();
    }
}

package ua.mateacademy.tania.lesson8.homework8;

import java.util.concurrent.*;

/**
 * Created by Tania Nebesna on 13.01.2019.
 */
public class VolatileExample {
    private static volatile int id = 1;

    public static void main(String[] args) {
        BlockingQueue<Runnable> runnableQueue = new LinkedBlockingQueue<>();

        for (int i = 0; i < 10; i++) {
            runnableQueue.add(() -> doSomething(id++));
        }

        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 1000, TimeUnit.MILLISECONDS, runnableQueue);
        executor.prestartAllCoreThreads();
        executor.shutdown();
    }

    private static void doSomething(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}

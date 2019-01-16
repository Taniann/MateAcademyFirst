package ua.mateacademy.tania.lesson9.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Tania Nebesna on 15.01.2019.
 */
public class MainExecutor {
    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource(0);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Thread thread1 = new Thread(new CountThread(commonResource, "thread-1"));
        Thread thread2 = new Thread(new CountThread(commonResource, "thread-2"));
        Thread thread3 = new Thread(new CountThread(commonResource, "thread-3"));
        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.execute(thread3);

        executorService.shutdown();

    }
}

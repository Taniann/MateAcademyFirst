package ua.mateacademy.tania.lesson9.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by Tania Nebesna on 15.01.2019.
 */
public class MainSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        CommonResource commonResource = new CommonResource(0);

        Thread thread1 = new Thread(new CountThread(commonResource, semaphore, "thread-1"));
        Thread thread2 = new Thread(new CountThread(commonResource, semaphore, "thread-2"));
        Thread thread3 = new Thread(new CountThread(commonResource, semaphore, "thread-3"));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

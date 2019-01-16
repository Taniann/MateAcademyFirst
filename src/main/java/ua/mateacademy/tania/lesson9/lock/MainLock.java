package ua.mateacademy.tania.lesson9.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Tania Nebesna on 15.01.2019.
 */
public class MainLock {
    public static void main(String[] args) {
       // Lock lock = new ReentrantLock();
        CommonResource commonResource = new CommonResource(0);

/*        Thread thread1 = new Thread(new CustomThread(commonResource, lock, "thread-1"));
        Thread thread2 = new Thread(new CustomThread(commonResource, lock, "thread-2"));
        Thread thread3 = new Thread(new CustomThread(commonResource, lock, "thread-3"));*/

        Thread thread1 = new Thread(new CustomThread(commonResource, "thread-1"));
        Thread thread2 = new Thread(new CustomThread(commonResource, "thread-2"));
        Thread thread3 = new Thread(new CustomThread(commonResource, "thread-3"));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

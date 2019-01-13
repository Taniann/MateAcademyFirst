package ua.mateacademy.tania.lesson8;

import java.util.Collections;

/**
 * Created by Tania Nebesna on 10.01.2019.
 */
public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        IncrementUtil incrementUtil = new IncrementUtil();
        Runnable runnable = () ->  {
            for (int j = 0; j < 5000; j++) {
                incrementUtil.increment();
            }
        };

        Thread thread1 = new Thread(runnable, "thread1" );
        Thread thread2 = new Thread(runnable, "thread2");

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(incrementUtil.getI());

    }
}

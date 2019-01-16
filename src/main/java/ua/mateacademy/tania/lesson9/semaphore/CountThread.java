package ua.mateacademy.tania.lesson9.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by Tania Nebesna on 15.01.2019.
 */
public class CountThread implements Runnable{
    private CommonResource commonResource;
    private Semaphore semaphore;
    private String name;

    public CountThread(CommonResource commonResource, Semaphore semaphore, String name) {
        this.commonResource = commonResource;
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " waiting");
            semaphore.acquire();
            for (int i = 0; i < 5; i++) {
                commonResource.incrementValue();
                System.out.println(name + ": " + commonResource.getValue());
                Thread.sleep(100);
            }
        }catch (InterruptedException ex) {
        }
        semaphore.release();
    }
}

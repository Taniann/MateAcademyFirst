package ua.mateacademy.tania.lesson9.lock;

import java.util.concurrent.locks.Lock;

/**
 * Created by Tania Nebesna on 15.01.2019.
 */
public class CustomThread implements Runnable{
    private CommonResource commonResource;
    private Lock lock;
    private String name;

    public CustomThread(CommonResource commonResource, Lock lock, String name) {
        this.commonResource = commonResource;
        this.lock = lock;
        this.name = name;
    }

    public CustomThread(CommonResource commonResource, String name) {
        this.commonResource = commonResource;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " waiting");
            //lock.lock();
            for (int i = 0; i < 5; i++) {
                commonResource.incrementValue();
                System.out.println(name + ": " + commonResource.getValue());
                Thread.sleep(100);
            }
        }catch (InterruptedException ex) {
        }
        //lock.unlock();
    }
}

package ua.mateacademy.tania.lesson8.homework8.synchronizedexample;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Tania Nebesna on 14.01.2019.
 */
public class Producer implements Runnable{
    private TransferObject transferObject;
    private volatile boolean stopped;
    private static volatile AtomicInteger id = new AtomicInteger(0);

    public Producer(TransferObject transferObject) {
        this.transferObject = transferObject;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        synchronized (transferObject) {
            while (!stopped) {
                transferObject.put(id.incrementAndGet());
            }
        }

    }

    public void stop() {
        stopped = true;
    }
}

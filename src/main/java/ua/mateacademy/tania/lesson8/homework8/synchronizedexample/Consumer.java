package ua.mateacademy.tania.lesson8.homework8.synchronizedexample;

/**
 * Created by Tania Nebesna on 14.01.2019.
 */
public class Consumer implements Runnable{
    private TransferObject transferObject;
    private volatile boolean stopped;

    public Consumer(TransferObject transferObject) {
        this.transferObject = transferObject;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        synchronized (transferObject) {
            while (!stopped) {
                transferObject.get();
            }
        }
    }

    public void stop() {
        stopped = true;
    }
}

package ua.mateacademy.tania.lesson8.homework8.synchronizedexample;

/**
 * Created by Tania Nebesna on 14.01.2019.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TransferObject transferObject = new TransferObject();
        Producer producer = new Producer(transferObject);
        Consumer consumer = new Consumer(transferObject);

        Thread.sleep(50);
        producer.stop();
        consumer.stop();
    }
}

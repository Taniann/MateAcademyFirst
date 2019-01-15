package ua.mateacademy.tania.lesson8.homework8.blockingQueue;

import ua.mateacademy.tania.lesson8.homework8.blockingQueue.Document;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Tania Nebesna on 13.01.2019.
 */
public class University implements Runnable {
    private BlockingQueue<Document> documents;

    public University(BlockingQueue<Document> documents) {
        this.documents = documents;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Document takenDocument = documents.take();
                System.out.println(takenDocument + " has been taken by " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


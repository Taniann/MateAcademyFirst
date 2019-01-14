package ua.mateacademy.tania.lesson8.homework8.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Tania Nebesna on 13.01.2019.
 */
public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Document> documents = new ArrayBlockingQueue<>(10);
        RandomDocumentGenerator documentGenerator = new RandomDocumentGenerator();


        Runnable university = new University(documents);

        Runnable admissionBoard = new AdmissionBoard(documents, documentGenerator);

        new Thread(admissionBoard).start();

        new Thread(university, "university1").start();
        new Thread(university, "university2").start();
    }
}

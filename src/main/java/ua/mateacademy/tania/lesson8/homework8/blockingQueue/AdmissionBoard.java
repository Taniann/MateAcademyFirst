package ua.mateacademy.tania.lesson8.homework8.blockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Tania Nebesna on 13.01.2019.
 */
public class AdmissionBoard implements Runnable {
    private BlockingQueue<Document> documents;
    private RandomDocumentGenerator documentGenerator;

    public AdmissionBoard(BlockingQueue<Document> documents, RandomDocumentGenerator documentGenerator) {
        this.documents = documents;
        this.documentGenerator = documentGenerator;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
                Document document = documentGenerator.next();
                documents.add(document);
                System.out.println(document + " has been added to Admission board");
        }
    }
}

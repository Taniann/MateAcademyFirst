package ua.mateacademy.tania.lesson8.homework8.blockingQueue;

import ua.mateacademy.tania.lesson8.homework8.blockingQueue.BioDocument;
import ua.mateacademy.tania.lesson8.homework8.blockingQueue.Document;
import ua.mateacademy.tania.lesson8.homework8.blockingQueue.MathDocument;

import java.util.Random;

/**
 * Created by Tania Nebesna on 13.01.2019.
 */
public class RandomDocumentGenerator {
    private Random random = new Random();

    public Document next(){
        switch(this.random.nextInt(2)) {
            case 0: return new MathDocument();
            case 1: return new BioDocument();
            default: return new MathDocument();
        }
    }
}

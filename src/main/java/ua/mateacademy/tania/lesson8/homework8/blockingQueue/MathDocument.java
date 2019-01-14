package ua.mateacademy.tania.lesson8.homework8.blockingQueue;

import ua.mateacademy.tania.lesson8.homework8.blockingQueue.Document;

/**
 * Created by Tania Nebesna on 13.01.2019.
 */
public class MathDocument implements Document {
    private static int idCounter = 1;
    private int id;

    public MathDocument() {
        this.id = idCounter++;
    }

    @Override
    public String toString() {
        return "MathDocument{" +
                "id=" + id +
                '}';
    }
}

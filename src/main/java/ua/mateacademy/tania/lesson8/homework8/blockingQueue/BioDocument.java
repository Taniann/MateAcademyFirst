package ua.mateacademy.tania.lesson8.homework8.blockingQueue;

/**
 * Created by Tania Nebesna on 13.01.2019.
 */
public class BioDocument implements Document {
    private static int idCounter = 1;
    private int id;

    public BioDocument() {
        this.id = idCounter++;
    }

    @Override
    public String toString() {
        return "BioDocument{" +
                "id=" + id +
                '}';
    }
}

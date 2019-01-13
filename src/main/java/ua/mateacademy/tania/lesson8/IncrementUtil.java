package ua.mateacademy.tania.lesson8;

/**
 * Created by Tania Nebesna on 10.01.2019.
 */
public class IncrementUtil {
    private  int i = 0;

    public  int getI() {
        return i;
    }

    public synchronized int increment() {
       return i++;
    }
}

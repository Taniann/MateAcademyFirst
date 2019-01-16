package ua.mateacademy.tania.lesson9;

/**
 * Created by Tania Nebesna on 15.01.2019.
 */
public class LazyThreadSafeSingleton {
    private static LazyThreadSafeSingleton instance;

    private LazyThreadSafeSingleton() {
    }

    public static LazyThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (LazyThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new LazyThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}

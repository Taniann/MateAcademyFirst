package ua.mateacademy.tania.lesson3.oopexample.second;

/**
 * Created by Таня on 26.12.2018.
 */
public abstract class PlayerAbstract {
    static final String SONG_NAME = "song№1";
    private final Double price;

    public PlayerAbstract(Double price) {
        this.price = price;
    }


    public abstract void playSong();
    public Double getPrice() {
        return price;
    }
}

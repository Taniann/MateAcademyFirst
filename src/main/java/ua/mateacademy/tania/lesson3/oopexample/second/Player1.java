package ua.mateacademy.tania.lesson3.oopexample.second;

/**
 * Created by Таня on 26.12.2018.
 */
public class Player1 extends PlayerAbstract {

    public Player1(Double price) {
        super(price);
    }

    @Override
    public void playSong() {
        System.out.println("Playing " + SONG_NAME);
    }

}

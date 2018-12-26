package ua.mateacademy.tania.lesson3.oopexample.first;


/**
 * Created by Таня on 25.12.2018.
 */
public class Player1 extends PlayerAbstract {

    public Player1(Double price) {
        super(price);
    }

    @Override
    public void playSong() {
        System.out.println("Playing " + PlaySong.SONG_NAME);
    }

}

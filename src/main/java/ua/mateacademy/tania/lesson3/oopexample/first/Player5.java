package ua.mateacademy.tania.lesson3.oopexample.first;


/**
 * Created by Таня on 25.12.2018.
 */
public class Player5 extends PlayerAbstract implements PlayAllSong {


    public Player5(Double price) {
        super(price);
    }

    @Override
    public void playAllSong() {
        for (int i = playlist.length - 1; i >= 0; i--) {
            System.out.println("Playing " + playlist[i]);
        }
    }

    @Override
    public void playSong() {
        System.out.println("Playing " + playlist[0]);
    }
}

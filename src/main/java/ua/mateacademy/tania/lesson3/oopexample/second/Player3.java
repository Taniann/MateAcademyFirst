package ua.mateacademy.tania.lesson3.oopexample.second;

/**
 * Created by Таня on 26.12.2018.
 */
public class Player3 extends PlayerAbstract implements PlayAllSong {

    public Player3(Double price) {
        super(price);
    }

    @Override
    public void playSong() {
        System.out.println("Playing " + playlist[0]);
    }

    @Override
    public void playAllSong() {
        for (String str : playlist) {
            System.out.println("Playing " + str);
        }
    }
}

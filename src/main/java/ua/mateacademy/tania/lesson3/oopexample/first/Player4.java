package ua.mateacademy.tania.lesson3.oopexample.first;



/**
 * Created by Таня on 25.12.2018.
 */
public class Player4 extends PlayerAbstract implements PlayAllSong {

    public Player4(Double price) {
        super(price);
    }

    @Override
    public void playSong() {
        System.out.println("Playing " + playlist[playlist.length - 1]);
    }

    @Override
    public void playAllSong() {
        for (String str : playlist) {
            System.out.println("Playing " + str);
        }
    }

}

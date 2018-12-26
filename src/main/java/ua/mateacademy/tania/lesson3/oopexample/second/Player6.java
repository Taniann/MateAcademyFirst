package ua.mateacademy.tania.lesson3.oopexample.second;

/**
 * Created by Таня on 26.12.2018.
 */
public class Player6 extends PlayerAbstract implements PlayAllSong {


    public Player6(Double price) {
        super(price);
    }

    @Override
    public void playAllSong() {
        for (String str : playlist) {
            System.out.println("Playing " + str);
        }
    }

    @Override
    public void playSong()  {
        System.out.println("Playing " + playlist[0]);
    }

    public void shuffle() {
        for (int i = 0; i < playlist.length - 1; i+=2) {
            String tmp = playlist[i];
            playlist[i] = playlist[i+1];
            playlist[i+1] = tmp;
        }
    }
}

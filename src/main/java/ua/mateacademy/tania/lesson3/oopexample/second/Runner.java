package ua.mateacademy.tania.lesson3.oopexample.second;

/**
 * Created by Таня on 26.12.2018.
 */
public class Runner {
    public static void main(String[] args) {
        System.out.println("player1:");
        Player1 player1 = new Player1(100.0);
        player1.playSong();

        System.out.println("player2:");
        Player2 player2 = new Player2(100.0);
        player2.playSong();

        System.out.println("player3");
        Player3 player3 = new Player3(170.0);
        player3.playSong();
        player3.playAllSong();

        System.out.println("player4");
        Player4 player4 = new Player4(200.0);
        player4.playSong();
        player4.playAllSong();

        System.out.println("player5");
        Player5 player5 = new Player5(220.0);
        player5.playSong();
        player5.playAllSong();

        System.out.println("player6");
        Player6 player6 = new Player6(250.0);
        player6.playSong();
        player6.playAllSong();
        player6.shuffle();
        System.out.println("after snuffle :");
        player6.playAllSong();
    }
}

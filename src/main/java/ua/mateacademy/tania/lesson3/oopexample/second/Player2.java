package ua.mateacademy.tania.lesson3.oopexample.second;

import ua.mateacademy.tania.lesson3.oopexample.first.PlayerAbstract;

/**
 * Created by Таня on 26.12.2018.
 */
public class Player2 extends PlayerAbstract {

    public Player2(Double price) {
        super(price);
    }

    @Override
    public void playSong() {
        System.out.println("error");
    }
}

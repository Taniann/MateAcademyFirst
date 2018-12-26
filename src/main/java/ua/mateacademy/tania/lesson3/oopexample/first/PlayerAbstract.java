package ua.mateacademy.tania.lesson3.oopexample.first;


/**
 * Created by Таня on 25.12.2018.
 */
public abstract class PlayerAbstract implements PlaySong {
    private final Double price;

    public PlayerAbstract(Double price) {
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }

}

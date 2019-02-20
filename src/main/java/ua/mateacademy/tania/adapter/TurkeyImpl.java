package ua.mateacademy.tania.adapter;

public class TurkeyImpl implements Turkey {
    @Override
    public void turkeyMethod() {
        System.out.println("turkey method");
    }

    @Override
    public void fly() {
        System.out.println("turkey fly");
    }
}

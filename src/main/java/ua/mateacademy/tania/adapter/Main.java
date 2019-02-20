package ua.mateacademy.tania.adapter;

public class Main {
    public static void main(String[] args) {
        TurkeyImpl turkey = new TurkeyImpl();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        turkeyAdapter.quack();
    }
}

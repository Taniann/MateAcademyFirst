package ua.mateacademy.tania.adapter;

public class TurkeyAdapter implements Duck {
    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.turkeyMethod();
    }

    @Override
    public void fly() {
        turkey.fly();
    }
}

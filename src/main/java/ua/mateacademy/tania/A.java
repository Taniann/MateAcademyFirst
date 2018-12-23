package ua.mateacademy.tania;

/**
 * Created by Таня on 23.12.2018.
 */
public class A {
    private int id;
    private String name;

    public A(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ABuilder builder() {
        return new ABuilder();
    }

    @Override
    public String toString() {
        return "A{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

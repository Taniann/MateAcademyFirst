package ua.mateacademy.tania;

public class ABuilder {
    private int id;
    private String name;

    public ABuilder setId(int id) {
        this.id = id;
        return this;
    }

    public ABuilder setName(String name) {
        this.name = name;
        return this;
    }

    public A createA() {
        return new A(id, name);
    }
}
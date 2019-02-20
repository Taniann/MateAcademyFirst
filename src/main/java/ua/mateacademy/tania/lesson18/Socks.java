package ua.mateacademy.tania.lesson18;

public abstract class Socks {
    private String type;
    private int size;
    private String color;

    public Socks(String type) {
        this.type = type;
    }

    public String getName() {
        return type;
    }

    public void setName(String name) {
        this.type = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Socks{" +
                "name='" + type + '\'' +
                ", size=" + size +
                ", color='" + color + '\'' +
                '}';
    }
}

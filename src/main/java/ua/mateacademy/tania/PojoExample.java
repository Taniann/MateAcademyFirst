package ua.mateacademy.tania;

import java.util.Objects;

/**
 * Created by Таня on 23.12.2018.
 */
public class PojoExample {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PojoExample(int id) {

        this.id = id;
    }

    @Override
    public String toString() {
        return "PojoExample{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PojoExample that = (PojoExample) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    public static void main(String[] args) {
        PojoExample p1 = new PojoExample(1);
        PojoExample p2 = new PojoExample(1);
        System.out.println(p1.equals(p2));
    }
}

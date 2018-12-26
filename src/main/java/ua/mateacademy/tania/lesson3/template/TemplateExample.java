package ua.mateacademy.tania.lesson3.template;

/**
 * Created by Таня on 25.12.2018.
 */
public abstract class TemplateExample {
    public void open() {
        System.out.println("Open");
    }

    public void close() {
        System.out.println("Close");
    }

    public abstract void doOperation();

    public void templateMethod() {
        open();
        doOperation();
        close();
    }
}

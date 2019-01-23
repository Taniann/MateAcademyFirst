package ua.mateacademy.tania.lesson11.logger;

/**
 * Created by Tania Nebesna on 22.01.2019.
 */
public class MainLogger {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.div(5, 2);
        calculator.div(3, 0);
    }
}

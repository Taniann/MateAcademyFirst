package ua.mateacademy.tania;

/**
 * Created by Таня on 20.12.2018.
 */
public class GeometryProgression {
    public static int calculate(int start, int koef, int number) {
        return (int) (start * Math.pow(koef, number - 1));
    }

    public static int calculateWithRecursion(int start, int koef, int number) {
        int nextElement = start * koef;
        number--;
        if (number == 1) return nextElement;
        return calculateWithRecursion(nextElement, koef, number);
    }

    public static void main(String[] args) {
        System.out.println(calculate(2, 3, 4));
        System.out.println(calculateWithRecursion(2, 3, 4));
    }
}

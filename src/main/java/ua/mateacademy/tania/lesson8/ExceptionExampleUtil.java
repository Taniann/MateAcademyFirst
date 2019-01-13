package ua.mateacademy.tania.lesson8;

/**
 * Created by Tania Nebesna on 10.01.2019.
 */
public class ExceptionExampleUtil {
    public static int multiply(int a, int b) throws Exception{
        if (a == 0 || b == 0) {
            throw new CustomCheckableException("wrong operation");
        }

        if (a==b) {
            throw new Exception("wrong operation a = b");
        }
        return a*b;
    }

    public static int divide(int a, int b) {
        if (b == 0) throw new CustomUncheckableException("wrong operation/ div null");

        return a/b;
    }
}

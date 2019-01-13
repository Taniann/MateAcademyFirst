package ua.mateacademy.tania.lesson8;

/**
 * Created by Tania Nebesna on 10.01.2019.
 */
public class Runner {
    public static void main(String[] args) {
/*        try {
            ExceptionExampleUtil.multiply(0, 5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ExceptionExampleUtil.divide(5, 0);
        ExceptionExampleUtil.divide(10, 2);*/


        try {
            ExceptionExampleUtil.multiply(5, 5);
            ExceptionExampleUtil.divide(5, 0);
        } catch (CustomCheckableException | CustomUncheckableException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

package ua.mateacademy.tania.lesson2;

/**
 * Created by Таня on 23.12.2018.
 */
public class Test {
    public static String staticValue;
    public static void staticMethod() {
        System.out.println("static method");
    }

    public static class NestedStatic implements InterfaceA {

        @Override
        public void someMethod1() {
            System.out.println("Nested static: someMethod1");
        }

        @Override
        public void someMethod2() {
            System.out.println("Nested static: someMethod2");
        }

    }

    public class InnerNonStatic implements InterfaceA {

        @Override
        public void someMethod1() {
            System.out.println("Non static: someMethod1");
        }

        @Override
        public void someMethod2() {
            System.out.println("Non static: someMethod2");
        }

    }
}

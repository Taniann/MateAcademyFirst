package ua.mateacademy.tania.lesson2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Таня on 23.12.2018.
 */
public class Main {
    public static void main(String[] args) {
        Test.NestedStatic nestedStatic = new Test.NestedStatic();
        Test.InnerNonStatic innerNonStatic = new Test().new InnerNonStatic();
        InterfaceA interfaceA = new InterfaceA() {
            @Override
            public void someMethod1() {
                System.out.println("anonim method1");
            }

            @Override
            public void someMethod2() {
                System.out.println("anonim method2");
            }
        };
/*        nestedStatic.someMethod1();
        nestedStatic.someMethod2();
        innerNonStatic.someMethod1();
        innerNonStatic.someMethod2();
        interfaceA.someMethod1();
        interfaceA.someMethod2();*/

        List<InterfaceA> list = new ArrayList<>();
        list.add(nestedStatic);
        list.add(innerNonStatic);
        list.add(interfaceA);

        list.stream().map(element -> element.getClass().getName()).forEach(System.out::println);
    }
}

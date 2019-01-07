package ua.mateacademy.tania.lesson6;

import java.util.Optional;

/**
 * Created by Tania Nebesna on 05.01.2019.
 */
public class OptionalExample {
    static String doSomething() {
        return "great";
    }

    public static void main(String[] args) {
        String str = "Cat";
        String strNull = null;

        Optional<String> optionalStr = Optional.of(str);
        Optional<String> optionalStrNull = Optional.ofNullable(strNull);

        System.out.println(optionalStr.isPresent());
        System.out.println(optionalStrNull.isPresent());

        optionalStr.ifPresent(val -> doSomething());
        System.out.println(optionalStrNull.orElse("orElse"));
        System.out.println(optionalStrNull.orElseGet(OptionalExample::doSomething));
        System.out.println(optionalStrNull.orElseThrow(UnsupportedOperationException::new));


    }
}

package ua.mateacademy.tania.lesson6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Tania Nebesna on 05.01.2019.
 */
public class Lesson6 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("a", "b", "c");
        stringList = Collections.unmodifiableList(stringList);
    }
}

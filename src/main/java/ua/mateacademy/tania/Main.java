package ua.mateacademy.tania;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Таня on 20.12.2018.
 */
public class Main {

    public static void main(String[] args) throws IOException {
/*        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        System.out.println(inputStr.toUpperCase());
        sc.close();*/
/*
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src/main/resources/input.txt");
            int i;
            while ((i = fileReader.read()) != -1) {
                if (i == 'j')
                    System.out.print("!!!");
                else System.out.print((char) Character.toUpperCase(i));

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileReader.close();
        }*/
/*      Path path = Paths.get("src/main/resources/input.txt");
      List<String> stringList = Files.lines(path).map(String::toUpperCase).map(str -> str.replaceAll("J", "!!!")).collect(Collectors.toList());

      Path outputPath = Paths.get("src/main/resources/output.txt");
      Files.write(outputPath,  stringList);*/

        String str = null;
        System.out.println(str);

    }
}

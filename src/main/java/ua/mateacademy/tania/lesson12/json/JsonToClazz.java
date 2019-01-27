package ua.mateacademy.tania.lesson12.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by Tania Nebesna on 24.01.2019.
 */
public class JsonToClazz {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            MateGroup mateGroup = mapper.readValue(new File("src/main/resources/json/MateGroup.json"),
                    MateGroup.class);
            System.out.println(mateGroup);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

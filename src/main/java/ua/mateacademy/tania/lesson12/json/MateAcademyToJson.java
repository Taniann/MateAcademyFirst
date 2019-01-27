package ua.mateacademy.tania.lesson12.json;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;

/**
 * Created by Tania Nebesna on 24.01.2019.
 */
public class MateAcademyToJson {
    public static void main(String[] args) {
        MateGroup mateGroup = MateGroup.mateGroupExampleCreator();
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());

        try {
            objectWriter.writeValue(new File("src/main/resources/json/MateGroup.json"), mateGroup);
            System.out.println(objectWriter.writeValueAsString(mateGroup));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

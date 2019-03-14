package ua.mateacademy.tania.spring.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by Tania Nebesna on 12.03.2019
 */
@Component
@PropertySource("spring/pig.properties")
public class Pig {
    @Value("${voice:default value}")
    private String voice;

    public String getVoice() {
        return voice;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "voice='" + voice + '\'' +
                '}';
    }
}

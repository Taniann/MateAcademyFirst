package ua.mateacademy.tania.spring.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by Tania Nebesna on 12.03.2019
 */
@Component
@DependsOn("pig")
public class Tiger {
    @Autowired
    //@Qualifier(value = "pig")
    private Pig pig;

    private String voice;

    public Tiger() {
    }

    public Tiger(Pig pig) {
        this.pig = pig;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    @Override
    public String toString() {
        return "Tiger say " + getVoice()
                + (Objects.nonNull(pig) ? " and very like animal that said:" + pig.getVoice() : "");
    }
}

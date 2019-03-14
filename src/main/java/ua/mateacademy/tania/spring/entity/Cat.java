package ua.mateacademy.tania.spring.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Tania Nebesna on 12.03.2019
 */
@Component
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cat {
    @Autowired
    private Bloha bloha;

    private String catId;

    public Cat() {
        catId = "Cat " + (int) (Math.random() * 1000);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "bloha=" + bloha +
                ", catId='" + catId + '\'' +
                '}';
    }
}

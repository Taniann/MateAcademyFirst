package ua.mateacademy.tania.springintro.hw.entity;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Created by Tania Nebesna on 14.03.2019
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Leaf {
    private int id;

    public Leaf() {
        id = (int) (Math.random() * 1000);
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "id=" + id +
                '}';
    }
}

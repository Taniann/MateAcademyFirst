package ua.mateacademy.tania.springintro.hw;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ua.mateacademy.tania.springintro.hw.entity.Violet;

/**
 * Created by Tania Nebesna on 14.03.2019
 */
@Component
public class VioletBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Violet) {
            System.out.println("In postProcessBeforeInitialization " + bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Violet) {
            System.out.println("In postProcessAfterInitialization " + bean);
        }
        return bean;
    }
}

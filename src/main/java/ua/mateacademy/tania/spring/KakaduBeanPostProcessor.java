package ua.mateacademy.tania.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ua.mateacademy.tania.spring.entity.Kakadu;

/**
 * Created by Tania Nebesna on 12.03.2019
 */
@Component
public class KakaduBeanPostProcessor implements BeanPostProcessor  {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Kakadu) {
            System.out.println("In postProcessBeforeInitialization " + bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Kakadu) {
            System.out.println("In postProcessAfterInitialization " + bean);
        }
        return bean;
    }
}

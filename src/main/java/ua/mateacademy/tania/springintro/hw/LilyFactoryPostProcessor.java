package ua.mateacademy.tania.springintro.hw;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;
import ua.mateacademy.tania.springintro.hw.entity.Lily;

/**
 * Created by Tania Nebesna on 14.03.2019
 */
@Component
public class LilyFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(Lily.class);
        beanDefinition.getPropertyValues().add("color", "colorFromBeanFactoryPostProcessor");

        ((DefaultListableBeanFactory) configurableListableBeanFactory).
                registerBeanDefinition("lily", beanDefinition);
    }
}

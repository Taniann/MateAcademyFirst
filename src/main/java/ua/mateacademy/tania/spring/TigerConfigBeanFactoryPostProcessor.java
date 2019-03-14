package ua.mateacademy.tania.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;
import ua.mateacademy.tania.spring.entity.Tiger;

/**
 * Created by Tania Nebesna on 12.03.2019
 */
@Component
public class TigerConfigBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(Tiger.class);
        beanDefinition.getPropertyValues().add("voice", "MURNav!!");

        ((DefaultListableBeanFactory) configurableListableBeanFactory).
                registerBeanDefinition("tiger", beanDefinition);
    }
}

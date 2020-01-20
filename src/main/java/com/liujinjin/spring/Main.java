package com.liujinjin.spring;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author liuxin
 * @date 2018/7/7
 */
public class Main {

    @Test
    public void loadSpring(){
        // ApplicationContext ac = new ClassPathXmlApplicationContext("spring-application.xml");

        ClassPathResource resource = new ClassPathResource("spring-application.xml");
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);

        T1 t1 = (T1) beanFactory.getBean("t1");
        t1.te();

        T2 t2 = (T2) beanFactory.getBean("t2");
        t2.t2();
    }

    @Test
    public void main() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-application.xml");

        T2 t2 = (T2) ac.getBean("t2");
        System.out.println(t2.hashCode());

        T2 t22 = (T2) ac.getBean("t2");
        System.out.println(t22.hashCode());

    }
}

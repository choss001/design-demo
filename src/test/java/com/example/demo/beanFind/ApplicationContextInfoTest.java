package com.example.demo.beanFind;

import com.example.demo.order.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ApplicationContextInfoTest {

  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("모든 빈 출력하기")
  void findAllBean() {
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();
    Arrays.stream(beanDefinitionNames).forEach(i -> System.out.println("name = " + i + " object = " + ac.getBean(i)));
  }

  @Test
  @DisplayName("애플리케이션 빈 출력하기")
  void findApplicationBean() {
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();
    Arrays.stream(beanDefinitionNames).filter(i ->
        ac.getBeanDefinition(i).getRole() == BeanDefinition.ROLE_APPLICATION)
        .forEach(i -> System.out.println("name = " + i + " object = " + ac.getBean(i)));
  }
}

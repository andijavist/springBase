package spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.stream.Collectors;

public class App {
public static void main(String[] args) {//точка входа в приложение
ApplicationContext ctx =
//все равно нужен либо xml файл или файл конфигурации
//        new ClassPathXmlApplicationContext("config.xml");
//вариант ниже для файла джаваконфигфораннотэйшн, без xml
      new AnnotationConfigApplicationContext(JavaConfigForAnnotation.class);
      Comp computer = ctx.getBean(Comp.class);
        System.out.println("CPU = "+ computer.getCpu().getVendor());
        System.out.println("Memory = " +
                computer.getMemory().stream().
                        map(Device::getVendor).collect(Collectors.joining(", ")) );


    }

}

package spring.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.stream.Collectors;

public class App {
public static void main(String[] args) {//точка входа в приложение
ApplicationContext ctx =
//вариант через файл xml-конфигурации   new ClassPathXmlApplicationContext("config.xml");
//вариант через прямое указание файла аннотации ниже
      new AnnotationConfigApplicationContext(JavaConfig.class);
      Comp computer = ctx.getBean(Comp.class);
        System.out.println("CPU = "+ computer.getCpu().getVendor());



        System.out.println("Memory = " +
                computer.getMemory().stream().
                        map(Device::getVendor).collect(Collectors.joining(", ")) );


    }

}

package spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {//точка входа в приложение
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//переменная ctx принимает контекст из xml файла и потом получает
// из него конкретные бины. на примере программы Computer
//про контекст на самом деле не так немного. класс Контекст это класс по которому мы подключаемся
//к кору спринга (контейнеру деменденси) и туда мы ему засовываем наш файл дтискриптор
// прилдожения, из которого контейнер-кор уже самостоятельно проектирует приложение
// по сути правильно мы расписываем в xml файле бины и их связи

// тупо создаем экземпляр  Comp computer =
// ctx.getBean(Comp.class); класс Context (экземпляр ctx)
// из переменной ctx (происходит обращение к контейнеру DI Spring)
// находит в указанном выше
// xml файле (bean.xml) класс Comp.class, создает бин с внедренными зависимостями
//по  строке property и возвращает нам
       Comp computer = ctx.getBean(Comp.class);
//System.out.println("CPU = " + computer.getCpu());
//интересное замечание по умолчанию метод toString ввышеизложенном
//к строке computer.getCpu() выдает такую строку getClass().getName() + @ + в 16-чном виде ХЭШ КОД!
//получается следующая строка "CPU = spring.xml.IntelCPU@222114ba"
//для устранения такого прикола сделаем исправим соут на нижеуказанный
// System.out.println("CPU = " + computer.getCpu().getVendor());//но стремно так много методов подряд вызывать, так как может быть посередине NULLPOINTER
//        ВЫВОД ДЛЯ КОЛЛЕКЦИИ
//System.out.println("Memory = " + computer.getMemory());
//эта строка  выдает [spring.xml.SonyMemory@45b9a632, spring.xml.KingstonMemory@25d250c6]
//дальше делаем через stream, появившиеся в java 8
//приводим коллекцию к стриму и применяем некоторый метод для каждого элемента этой последовательности
//System.out.println("Memory = " + computer.getMemory().stream().map(m ->System.out.println(m);m.getVendor()));
//            ВОПРОС!!! КАК ЭТО РАБОТАЕТ???? выше 1 прием
//            ниже 2 прием
//строка collect(Collectors.joining() приводит в строку все значения из коллекции "склеивает"
//System.out.println("Memory = " + computer.getMemory().stream().map(m ->m.getVendor()).collect(Collectors.joining(", ")) );
//ниже пример со ссылкой на метод getVendor "::", это укороченный вариант выражений написанных выше
        System.out.println("Memory = " +
                computer.getMemory().stream().
                        map(Device::getVendor).collect(Collectors.joining(", ")) );


//        System.out.println("Memory: " + comp.getMemoryList()
//                .stream()
//                .map(Device::getVendor)
//                .collect(Collectors.joining(", ")));

    }

}

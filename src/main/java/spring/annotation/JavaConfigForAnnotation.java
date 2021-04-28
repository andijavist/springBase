package spring.annotation;


//предыдущем варианте разметки (предыдущий пакет) мы явно прописывали все бины в файле "конфиг..."
//и спринг их сканировал через ссылку на этот файл в разделе APP и прицеплял.
//в данном примере все аннотации раскиданы по коду и так просто просканировать не получится
//для того чтобы просканировать весь проект на наличие "@Component" мы должны это явно задать в конфиг-=файле
//путем дописывания аннотаций @Confirueation , @ComponentScan

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
//@ComponentScan //по умолчанию будет сканироваться пакет, гед находится конфиг-файл,
// или же во вложенном пакете. Если мы хотим просканнировать конкретный пакет,
// то нужно прописывать как укахзано ниже
@ComponentScan (basePackages = "spring.annotation")
//@ComponentScan (basePackages = {"spring.annotation".....})либо если пакетов больше, их можно перечислить в таких скобках

public class JavaConfigForAnnotation {

    //в конфиге можно миксовать сканирование бинов по анотациям и задание бинов явно в конфиге
    //ниже зададим пару бинов
//    @Bean
//    public List <Memory> memoryList (){
//        return List.of(new SonyMemory());
        //в файле Comp также по автовайрингу на сеттере мемори все так же подцепится, но у меня не рабоатет,
        // заебал он если честно сто вариантов, уже некуда((((
        // я закончил на 4 ч 12 дальше не хочу смотреть по всякой мелочс
//    }
}

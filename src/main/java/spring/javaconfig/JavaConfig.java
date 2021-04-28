package spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration

//в xml мы прописывали, что нуждно делать
//здесь мы (конфиг) сами создаем бины и передаем их контейнеру
public class JavaConfig {

    @Bean ("mycompiter")//можем дать имя бину,
    // по умолчанию бин бедет называться по имени метода comp(),
    // который нам будет его возврашщать
//    @Scope (...)
    public Comp comp(){
        Comp c = new Comp();
        c.setCpu(intelCPU());
//Варик с листом мемори
//        c.setMemory(Arrays.asList(
//                                  kingston(),
//                                  sony(),
//                                  sony()
//                                 )
//                    );
//внизу другой способ вывода листа, через статический метод of интерфейса List
//List.of создает неизменяемый список в отличии от Arrays.asList
//        c.setMemory(List.of( kingston(),
//                                  sony(),
//                                  sony()));
        c.setMemory(memoryList());
        return c;
    }

    @Bean
    public CPU intelCPU(){
        return new IntelCPU();
    }
    @Bean
    public CPU amdCPU(){return new AmdCpu();
//далее мы создаем xml аннотацию и записываем в ней,
// где нашу аннотацию искать через config.xml, путь к config.xml указываем в разделе App (main)
}

//Варик с листом
@Bean
    public Memory kingston()
    {
        return new KingstonMemory();
    }

    @Bean
    public Memory sony(){
        return new SonyMemory();
    }
//также можно сделать метод, который будет нам возвращать
// такой же лист оф
    @Bean
    public List <Memory> memoryList(){
        return List.of( kingston(),
                sony(),
                sony(),
                kingston());
    }

}

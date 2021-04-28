package spring.xml;

import java.util.List;

public class Comp {
    private CPU cpu;
    private List <Memory> memory;//"виды памяти" находится в листе

//   2 СПОСОБ ВНЕДРЕНИЯ ЗАВИСИМОСТИ
//    внедрение через КОНСТРУКТОР
//

//    public Comp(CPU cpu) {
//        this.cpu = cpu;
//    }

    //  1 СПОСОБ ВНЕДРЕНИЯ ЗАВИСИМОСТИ
//   через СЕТТЕР. сеттер был создан для внедрения через него в xml  файле зависимости бина
//    Геттер был создан по приколу
//    public CPU getCpu() {
//        return cpu;
//    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }
//ПРИМЕРЫ С ЛИСТАМИ!

//создаем геттеры и сеттеры для листа значений
    public List<Memory> getMemory() {
        return memory;
    }

    public void setMemory(List<Memory> memory) {
        this.memory = memory;
    }
}

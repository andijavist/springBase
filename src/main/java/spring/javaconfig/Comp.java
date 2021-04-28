package spring.javaconfig;

import org.springframework.beans.factory.BeanNameAware;

import java.util.List;

//можем имплементировать интерфейс BeanNameAware, чтобы получить доступ к именам бинов
public class Comp implements BeanNameAware {
    private CPU cpu;
    private List <Memory> memory;
    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }
    public CPU getCpu() {
        return cpu;
    }

        public List<Memory> getMemory() {
        return memory;
    }
    public void setMemory(List<Memory> memory) {
        this.memory = memory;
    }

//    можем посмотреть имя бина
//    (именно основного бина,
//    так как мы на него повесили implements BeanNameAware)
    @Override
    public void setBeanName(String name) {
        System.out.println("Competer name = " + name);
    }
}

package spring.annotation;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

//так как наш класс comp управляется контейнером
// его необходимо пометить аннотацией @Component, есть еще Service и Repository
//ВНИМАНИЕ ТОЧКА ВХОДА - СТРОКА В XML ГДЕ МЫ ДЕЛАЕМ СКАНИРОВАНИЕ, ТАК ЖЕ КАК В ВАРИАНТЕ С JAVACONFIG(ДРУГОЙ ПАКЕТ)

@Component
public class Comp {
//теперь аннотацией помечаем то, что будем внедрять в comp

//1) способ внедрения чяерез пометку полей аннотацией @Autowired
//данный способ будет работать через рефлексия АПИ. (вариант не очень хороший, не очень понял почему, но вроде из за того, что мы не можем менять что то...)
//Данное внедрение все равно будет происходить, даже если у нас не прописаны setters
//@Autowired
//private CPU cpu;
//@Autowired
//private List <Memory> memory;

//4 способ через собственную аннотацию @MyCpu
//вариант похож на первый способ.
//@Autowired
//@MyCpu
//private CPU cpu;
//private List<Memory> memory;


//как  в xml файле autoviering осуществляется по умолчанию "bytype",
// что првиодит к конфликту, он находит два cpu и не может дальше их прицепить
// если указать помету @Component("cpu")  в классе бина-зависимости, то spring
//подцепит его, а другой пропустит
private CPU cpu;

private List<Memory> memory;

public CPU getCpu() {
        return cpu;
    }

public List<Memory> getMemory() {
        return memory;
    }

//2 вариант внедрения через конструктор
//ставим аннотацию @Autowired на конструктор
//@Autowired  //ниже явно указываем что внедряем
//public Comp(@Qualifier("INTEL") CPU cpu) {this.cpu = cpu;}
//
//@Autowired
//public Comp(List<Memory> memory) {this.memory = memory;}

//3 вариант внедрения через сеттер
//@Autowired
//@Qualifier("INTEL")
//если несколько компонентов-бинов, то надо явно указывать какой из них внедрять
//public void setCpu( CPU cpu) {
//this.cpu = cpu;

//4 способ с отдельнйо аннотацией @MuCpu
//@Autowired
//public void setCpu(@MyCpu CPU cpu) {this.cpu = cpu; }

//4 способ с отдельнйо аннотацией @MuCpu
//через целый сеттер
@Autowired
@MyCpu
public void setCpu( CPU cpu) {this.cpu = cpu; }

@Autowired //в случае с листом без использования Qualifier,
// все элементы подцепляются без конфликта типов (по умолчанию подцепка идет byType)
// в рандомном порядке
// если используем qualifier то будет подцепляться то что пометили
public void setMemory(List<Memory> memory) {this.memory = memory;}
}


package spring.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

//import java.lang.annotation.ElementType;

import static java.lang.annotation.ElementType.*;
//выше строка - статический импорт через *, чтобы подтянуть несколько констант
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

//есть возможность создавать
// собственные объекты-анотации (кастомный)

@Qualifier //не полнятно "собственный квалифаер, который не требует указания имени,
// а фактически уже само наличие аннотации уже будет указывать,к акой бин нужно внедрять"
//все анотации помечены аннотациями типа @Target или @Retention
//@Target это то, к чему можно будет применить, например к классу или к полю (есть еще)
//
//@Target(ElementType.TYPE)//строка с обыным импортом. тайп для типа - то есть класса
@Target({TYPE, FIELD, PARAMETER, METHOD})
//константа PARAMETER, чтобы совать аннотацию в параметры методов или конструктор
//константа METHOD - для того. чтобы сунуть сам метод,типа через целый сеттер (через конструткор работать не будет)
//выше строка со статическим импортом, сразу подтягиваем несколько констант
// TYPE для типа - то есть класса, FIELD для поля
@Retention(RetentionPolicy.RUNTIME)//описывает какая будет область видимости у анностации MyCpu
//SOURCE - исх код, CLASS - после компила будут записаны в класс, но при загрузке в виртуальную машину будут удалены
// RUNTIME - будет видна даже в рантайме (динамически)
public @interface MyCpu {}

//дальше можно пометить любой бин,
// который будет подгружен в основной аннотацией @MyCou
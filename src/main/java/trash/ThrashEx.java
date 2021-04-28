package trash;

import java.util.*;

public class ThrashEx {

    public static void main(String[] args) {
//        Collection <Integer> listEx = new HashSet<>();//неупорядоченнакя коллекция
//          Collection <Integer> listEx = new ArrayList<>();//упорядоченнакя коллекция
//        List <Integer> listEx = new ArrayList<>();//дргуой вариант создания коллекции, List расширяет Collection
        List <Integer> listEx = new LinkedList<>();//вари ант реализации в виде LinkedList

        listEx.add(12);
        listEx.add(0);
        listEx.add(220);
        listEx.add(13);
        listEx.add(14);
        System.out.println(listEx);
        //создаем отдельный элемент имплементирующий интерфейс iterator, для того, чтобы в него положить
        //вызванный iterator из листа. Делаем это для того, чтобы потом суметь перебрать коллекцию. List
        Iterator <Integer> iterator = listEx.iterator();

        while(iterator.hasNext()){
//            System.out.println(listEx.iterator().next());
// ВЫШЕ если просто записать такую строчку, то получится что итератор будет печатать только первый элемент, придется делать вывод через итератор отдельный
        Integer nextPos = iterator.next();
            System.out.println(nextPos);

        }
        System.out.println("__________________________");
//вариант перебора коллекции, по аналогии с массивом,в случае
        for (int i = 0; i <listEx.size() ; i++) {
             System.out.println(listEx.get(i));
        }
        System.out.println("coll hranit 10 ? otvet - "+ listEx.contains(10));//проверка наличия элемента в коллекции
        System.out.println("coll hranit 10 ? otvet - "+ listEx.contains(12));
//        listEx.s
    }



}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//10. набор групп
public class DataDemo {

    //4) Напишите класс DataDemo со статическим методом getAll, который получает на вход
    // объект класса Data и возвращает список целых чисел.
    // Метод с помощью итератора строит список всех чисел, входящих во все группы данных.
    public static List<Integer> getAll(Data data) {
        List<Integer> list = new ArrayList<>();
        final Iterator<Integer> iterator = data.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

}

import java.util.*;

public class ListDemo {
    //1.
    // Вход: список строк и символ.
    // Выход: количество строк входного списка, у которых первый символ совпадает с заданным.
    public int firstSymbolEqual(List<String> list, char firstChar) {
        int result = 0;
        for (String str: list) {
            if (!str.isEmpty() && str.charAt(0) == firstChar) {
                result++;
            }
        }
        return result;
    }

    // 2. ...
    // Напишите метод который получает на вход список объектов типа Human и еще один объект типа Human.
    // Результат — список однофамильцев заданного человека среди людей из входного списка.
    public List<Human> findSurnameEqual(List<Human> list, Human findHuman) {
        List<Human> result = new ArrayList<>();
        // искомая фамилия
        final String findSurname = findHuman.getSurname();
        for (Human human: list) {
            // проверяем однофамильцев (без проверки на мужские и женские фамилии)
            if (findSurname.equals(human.getSurname())) {
                result.add(human);
            }
        }
        return result;
    }

    //3.
    // Вход: список объектов типа Human и еще один объект типа Human.
    // Выход — копия входного списка, не содержащая выделенного человека.
    // При изменении элементов входного списка элементы выходного изменяться не должны.
    public List<Human> withoutHuman(List<Human> list, Human findHuman) {
        List<Human> result = new ArrayList<>();
        for (Human human: list) {
            // не берем данного человека (можно было бы проверить - (findHuman.hashCode() != human.hashCode()) )
            if (!findHuman.equals(human)) {
                result.add(new Human(human));
            }
        }
        return result;
    }

    //4.
    // Вход: список множеств целых чисел и еще одно множество.
    // Выход: список всех множеств входного списка, которые не пересекаются с заданным множеством.
    public List<int[]> notIntersect(List<int[]> list, int[] array) {
        List<int[]> result = new ArrayList<>();
        // делаем из заданного множества HashSet для удобства сравнения
        Set<Integer> set = new HashSet<>();
        for (int value: array) {
            set.add(value);
        }
        for (int[] ints: list) {
            // проверяем пересекаются ли множества
            boolean intersect = false;
            for (int value: ints) {
                if (set.contains(value)) {
                    intersect = true;
                    break;
                }
            }
            if (!intersect) {
                // не пересекаются
                result.add(ints);
            }
        }
        return result;
    }

    //5. *...
    // Напишите метод получает на вход список, состоящий из объектов типа Human и его производных классов.
    // Результат — множество людей из входного списка с максимальным возрастом.
    public List<Human> oldHuman(List<Human> list) {
        List<Human> result = new ArrayList<>();
        // определяем  максимальный возраст
        int maxAge = Integer.MIN_VALUE;
        for (Human human: list) {
            if (human.getAge() > maxAge) {
                maxAge = human.getAge();
            }
        }
        for (Human human: list) {
            if (human.getAge() == maxAge) {
                result.add(human);
            }
        }
        return result;
    }

    private List<Human> getHumans(Map<Integer, Human> map, int[] array, int age) {
        List<Human> result = new ArrayList<>();
        for (int value: array) {
            final Human human = map.get(value);
            if (human != null && human.getAge() >= age) {
                result.add(human);
            }
        }
        return result;
    }

    //7.
    // Имеется набор людей, каждому человеку задан уникальный целочисленный идентификатор.
    // Напишите метод, который получает на вход отображение (Map)
    // целочисленных идентификаторов в объекты типа Human и множество целых чисел.
    // Результат — множество людей, идентификаторы которых содержатся во входном множестве.
    public List<Human> getHumans(Map<Integer, Human> map, int[] array) {
        return getHumans(map, array, 0);
    }

    //8.
    // Для отображения из задачи 7 постройте список идентификаторов людей, чей возраст не менее 18 лет.
    public List<Human> getHumansNotYoung(Map<Integer, Human> map, int[] array) {
        return getHumans(map, array, 18);
    }
}

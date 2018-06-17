import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//10. набор групп
public class Data {
    // название набора (строка символов)
    private String name;
    // сам набор групп в виде массива
    private Group[] groups;

    // Должна быть возможность создать объект так:
    //Data data = new Data(“Test data”, new Group(...), new Group(...));
    public Data(String name, Group... groups) {
        this.name = name;
//        this.groups = groups;  // fixme
        this.groups = new Group[groups.length];
        for (int i = 0; i < groups.length; i++) {
            this.groups[i] = groups[i];
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
//        this.groups = groups; // fixme
        this.groups = new Group[groups.length];
        for (int i = 0; i < groups.length; i++) {
            this.groups[i] = groups[i];
        }
    }


    // длина массива
    public int length() {
        return groups.length;
    }

    //3) Напишите итератор, который для объекта класса Data перебирает все числа во всех его группах.
    // Добавьте в класс Data метод iterator().
    public Iterator<Integer> iterator0() {
        List<Integer> collection = new ArrayList<>();
        for (Group group : getGroups()) {
            for (int i : group.getArray()) {
                collection.add(i);
            }
        }
        return collection.iterator();
    }

    public Iterator<Integer> iterator() {
        return new DataIterator(this);
    }

    static class DataIterator implements Iterator {
        // сам набор групп в виде массива
        private Group[] groups;

        // количество чисел во всех группах (при next - уменьшается)
        private int count;
        // текущий номер группы
        private int currNumberGroup = 0;
        // текущий номер в группе
        private int numberInGroup = 0;

        public DataIterator(Data data) {
            this.groups = data.getGroups();
            count = 0;
            for (Group group : groups) {
                count += group.getArray().length;
            }
        }

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                return null;
            }
            while (groups[currNumberGroup].getArray().length <= numberInGroup) {
                currNumberGroup++;
                numberInGroup = 0;
            }
            count--;
            int value = groups[currNumberGroup].getArray()[numberInGroup];
            numberInGroup++;
            return value;
        }
    }
}

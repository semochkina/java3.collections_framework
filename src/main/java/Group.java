//10. группа данных
public class Group {
    // идентификатор
    private int id;
    // сами данные
    private int[] array;

    // Должна быть возможность создать объект так:
    // Group group = new Group(100, 1, 2, 3); // 100 – номер группы
    public Group(int id, Integer... array) {
        this.id = id;
        this.array = new int[array.length];
        for (int i = 0; i <array.length; i++) {
            this.array[i] = array[i];
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getLength() {
        return array.length;
    }
}

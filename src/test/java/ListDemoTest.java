import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListDemoTest {
    private ListDemo listDemo = new ListDemo();
    private Human human1 = new Human("Фамилия1", "Имя1", "Отчество1", 11);
    private Human human2 = new Human("Фамилия2", "Имя2", "Отчество2", 22);
    private Human human3 = new Human("Фамилия3", "Имя3", "Отчество3", 33);
    private Human human4 = new Human("Фамилия4", "Имя4", "Отчество4", 44);
    private Human human5 = new Human("Фамилия5", "Имя5", "Отчество5", 55);

    @Test
    public void firstSymbolEqualTest() {
        Assert.assertEquals(2, listDemo.firstSymbolEqual(Arrays.asList("my", "one", "the", "tree"), 't'));
    }

    @Test
    public void findSurnameEqualTest() {
        Human human = new Human(human1);
        final List<Human> surnameEqual = listDemo.findSurnameEqual(Arrays.asList(human1, human2, human3, human4, human5), human);
        Assert.assertEquals(surnameEqual.size(), 1);
        Assert.assertEquals(surnameEqual.get(0).getSurname(), human.getSurname());
    }

    @Test
    public void withoutHumanTest() {
        Human human = new Human(human1);
        final List<Human> surnameEqual = listDemo.withoutHuman(Arrays.asList(human2, human), human2);
        Assert.assertEquals(surnameEqual.size(), 1);
        Assert.assertEquals(surnameEqual.get(0).getSurname(), human.getSurname());
        human.setSurname("Иванов");
        Assert.assertNotEquals(surnameEqual.get(0).getSurname(), human.getSurname());
    }

    @Test
    public void notIntersectTest() {
        int[] array = {1, 2, 3};
        List<int[]> ints = listDemo.notIntersect(Arrays.asList(
                new int[]{1, 3, 5},
                new int[]{2, 4, 6},
                new int[]{3, 5, 7},
                new int[]{4, 6, 8}), array);
        Assert.assertEquals(ints.size(), 1);
        Assert.assertEquals(ints.get(0)[0], 4);
        Assert.assertEquals(ints.get(0)[1], 6);
        Assert.assertEquals(ints.get(0)[2], 8);
    }

    @Test
    public void oldHumanTest() {
        Student student = new Student(new Human(human1), "Математика");
        final List<Human> surnameEqual = listDemo.oldHuman(Arrays.asList(student, human2, human3, human4, human5));
        Assert.assertEquals(surnameEqual.size(), 1);
        Assert.assertEquals(surnameEqual.get(0).getAge(), 55);
    }

    @Test
    public void getHumansTest() {
        Map<Integer, Human> map = new HashMap<>();
        map.put(1, human1);
        map.put(2, human2);
        map.put(3, human3);
        map.put(4, human4);
        map.put(5, human5);
        final List<Human> surnameEqual = listDemo.getHumans(map, new int[] {1});
        Assert.assertEquals(surnameEqual.size(), 1);
        Assert.assertEquals(surnameEqual.get(0).getAge(), 11);
    }


    @Test
    public void getHumansNotYoungTest() {
        Map<Integer, Human> map = new HashMap<>();
        map.put(1, human1);
        map.put(2, human2);
        map.put(3, human3);
        map.put(4, human4);
        map.put(5, human5);
        final List<Human> surnameEqual = listDemo.getHumansNotYoung(map, new int[] {1, 2, 3, 4, 5});
        Assert.assertEquals(surnameEqual.size(), 4);
    }

}
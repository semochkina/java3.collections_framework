import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DataDemoTest {

    @Test
    public void getAllTest() {
        Data data = new Data("Test data"
                , new Group(1, 1, 11, 111, 1111)
                , new Group(2, 2, 22, 222, 2222)
                , new Group(3, 3, 33, 333, 3333)
                , new Group(4, 4, 44, 444, 4444)
                , new Group(5, 5, 55, 555, 5555)
        );
        List<Integer> list = DataDemo.getAll(data);
        System.out.println(list);
        Assert.assertEquals(list.size(), 20);
        Assert.assertEquals(list.get(0), new Integer(1));
        Assert.assertEquals(list.get(1), new Integer(11));
    }
}

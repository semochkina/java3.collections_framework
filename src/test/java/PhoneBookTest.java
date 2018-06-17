import org.junit.Assert;
import org.junit.Test;

public class PhoneBookTest {

    @Test
    public void getAllTest() {
        Human human1 = new Human("Фамилия1", "Имя1", "Отчество1", 11);
        PhoneBook book = new PhoneBook();
        book.addPhone(human1, "11-11-11");
        book.addPhone(human1, "11-11-11-11");
        book.addPhone(human1, "11-11-11-11-11");
        Assert.assertEquals(book.getPhones(human1).size(), 3);
        Assert.assertTrue(book.removePhone(human1, "11-11-11-11-11"));
        Assert.assertFalse(book.removePhone(human1, "11-11-11-11-11"));
        Assert.assertEquals(book.getPhones(human1).size(), 2);

        Human human = book.getHuman("11-11-11");
        Assert.assertEquals(human, human1);
    }
}

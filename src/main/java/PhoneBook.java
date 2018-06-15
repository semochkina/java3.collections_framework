import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//9. *Напишите класс PhoneBook (телефонная книга).
public class PhoneBook {
    // Книга представляет собой отображение человека в список его номеров телефонов (номер телефона — строка).
    private Map<Human, List<String>> map = new HashMap<>();

    // добавить телефон
    public void addPhone(Human human, String phone) {
        List<String> phones = map.get(human);
        if (phones == null) {
            phones = new ArrayList<>();
            map.put(human, phones);
        }
        phones.add(phone);
    }

    // удалить телефон
    public boolean removePhone(Human human, String phone) {
        List<String> phones = map.get(human);
        if (phones == null) {
            return false;
        }
        return phones.remove(phone);
    }

    // получить список телефонов по человеку
    public List<String> getPhones(Human human) {
        return map.get(human);
    }

    // найти человека по номеру телефона
    public Human getHuman(String phone) {
        for (Map.Entry<Human, List<String>> entry : map.entrySet()) {
            if (entry.getValue().contains(phone)) {
                return entry.getKey();
            }
        }
        return null;
    }
}

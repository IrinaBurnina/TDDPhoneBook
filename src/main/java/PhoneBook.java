import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    public PhoneBook() {
    }

    private static Map<String, String> book = new HashMap<>();

    public int add(String phoneNumber, String name) {
        if (!book.containsKey(phoneNumber)) {
            synchronized (book) {
                if (!book.containsKey(phoneNumber)) {
                    book.put(phoneNumber, name);
                }
            }
        } else {
            synchronized (book) {
                if (book.containsValue(phoneNumber)) {
                    book.replace(phoneNumber, book.get(phoneNumber), name);
                }
            }
        }
        return book.size();
    }

    public String findByNumber(String phoneNumber) {
        if (book.containsKey(phoneNumber)) {
            return book.getOrDefault(phoneNumber, "Без имени");
        }
        return null;
    }
}

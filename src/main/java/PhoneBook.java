import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    public PhoneBook() {
    }

    private static final Map<String, String> book = new HashMap<>();

    public int add(String phoneNumber, String name) {
        if (!book.containsKey(phoneNumber)) {

            if (!book.containsKey(phoneNumber)) {
                book.put(phoneNumber, name);
            }

        } else {

            if (book.containsValue(phoneNumber)) {
                book.replace(phoneNumber, book.get(phoneNumber), name);
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

    public String findByName(String name) {
        if (book.containsValue(name)) {
            for (String phoneNumber : book.keySet()) {
                if (name.equals(book.get(phoneNumber))) {
                    return phoneNumber;
                }
            }
        }
        return null;
    }

    public void printAllNames() {
        StringBuilder sb = new StringBuilder();
        sb.append("Контакты телефонной книги: \n");
        for (Map.Entry<String, String> contact : book.entrySet()) {
            sb.append("Контакт : имя = ")
                    .append(contact.getKey())
                    .append("-> номер = ")
                    .append(contact.getValue());
        }
        System.out.println(sb);
    }
}

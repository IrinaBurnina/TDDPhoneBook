import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.AssertJUnit.assertTrue;

public class PhoneBookTest {

    @Test
    public void addTest() {
        String name = "Алиса";
        String phoneNumber = "2231396";
        PhoneBook phoneBook = new PhoneBook();
        int result = phoneBook.add(name, phoneNumber);
        Map<String, String> mapPhonebookTest = new HashMap<>();
        mapPhonebookTest.put(phoneNumber, name);
        assertTrue("Неверное добавление контакта", result == mapPhonebookTest.size());
    }

    @Test
    public void addUniquePhoneNumberTest() {
        String name = "Алиса";
        String phoneNumber = "2231396";
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(phoneNumber, name);
        int resultDoubleAdd = phoneBook.add(phoneNumber, name);
        Map<String, String> mapPhonebookTest = new HashMap<>();
        mapPhonebookTest.put(phoneNumber, name);
        assertTrue("Неуникальное добавление контакта", resultDoubleAdd == mapPhonebookTest.size());
    }

    @Test
    public void findByNumberTest() {
        String name = "Алиса";
        String phoneNumber = "2231396";
        Map<String, String> mapPhonebookTest = new HashMap<>();
        mapPhonebookTest.put(phoneNumber, name);
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(phoneNumber, name);
        String testedName = phoneBook.findByNumber(phoneNumber);
        String nameAtMapTest = mapPhonebookTest.get(phoneNumber);
        assertTrue("Не найдено имя по номеру контакта", testedName == nameAtMapTest);
    }
}

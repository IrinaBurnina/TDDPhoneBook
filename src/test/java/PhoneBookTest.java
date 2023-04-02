import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class PhoneBookTest {

    @Test
    public void addTest() {
        String name = "Алиса";
        String phoneNumber = "2231396";
        String name2 = "Мила";
        String phoneNumber2 = "5554422";
        PhoneBook phoneBook = new PhoneBook();
        int result = phoneBook.add(name, phoneNumber);
        int result2 = phoneBook.add(name2, phoneNumber2);
        assertEquals("Неверное добавление контакта", result2, result + 1);
    }

    @Test
    public void addUniquePhoneNumberTest() {
        String name = "Алиса Селезнева";
        String phoneNumber = "2231396";
        PhoneBook phoneBook = new PhoneBook();
        int newSize = phoneBook.add(phoneNumber, name);
        int resultDoubleAdd = phoneBook.add(phoneNumber, name);
        assertEquals("На уникальное добавление контакта тест не прошел", resultDoubleAdd, newSize);
    }

    @Test
    public void findByNumberTest() {
        String name = "Алиса";
        String phoneNumber = "2231396";
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(phoneNumber, name);
        String testedName = phoneBook.findByNumber(phoneNumber);
        assertSame("Не найдено имя по номеру контакта", testedName, name);
    }

    @Test
    public void findByName() {
        String name = "Алиса";
        String phoneNumber = "2231396";
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(phoneNumber, name);
        String testedPhoneNumber = phoneBook.findByName(name);
        assertSame("Не найдено имя по номеру контакта", testedPhoneNumber, phoneNumber);
    }
}

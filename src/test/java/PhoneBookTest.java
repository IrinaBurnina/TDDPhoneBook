import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.AssertJUnit.assertTrue;

public class PhoneBookTest {

    @Test
    public void addTest() {
        String name = "Алиса";
        String phoneNumber = "2231396";
        PhoneBook phoneBook = new PhoneBook();
        int result = phoneBook.add();
        Map<String, String> mapPhonebookTest = null;
        mapPhonebookTest.put(phoneNumber, name);
        assertTrue("Неверное добавление контакта", result== mapPhonebookTest.size());
    }
    @Test
    public void addUniquePhoneNumberTest(){
        String name = "Алиса";
        String phoneNumber = "2231396";
        PhoneBook phoneBook=new PhoneBook();
        int result= phoneBook.add();
        int resultDoubleAdd=phoneBook.add();
        Map<String, String> mapPhonebookTest = null;
        mapPhonebookTest.put(phoneNumber, name);
        assertTrue("Неуникальное добавление контакта",resultDoubleAdd== mapPhonebookTest.size());


    }


}

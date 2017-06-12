package app.collections.phone_book;

import app.collections.humans.Human;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static app.collections.ListDemo.printCollectionToStdout;
import static org.junit.Assert.*;

// переписать т.к. в одном месте я добавил доп. List
// 9
public class TestPhoneBook {
    @Test
    public void testPhoneBook() {
        PhoneBook phoneBook = new PhoneBook();

        Human
                roman = new Human("Roman", "Fins", 17),
                frodo = new Human("Frodo", "Beggins", 37);

        String
                frodoRemove = "1213",
                frodoNotRemove = "3214",
                notInFrodo = "-";
        String[]
                frodoStr = {frodoRemove, frodoNotRemove, "12312"},
                romanStr = {"7567676"};
        List<String>
                frodoNumbers = Arrays.asList(frodoStr),
                romanNumbers = Arrays.asList(romanStr);

        phoneBook.addPhoneNumbers(frodo, frodoNumbers);
        phoneBook.removePhoneNumber(frodoRemove);
        phoneBook.removePhoneNumber(notInFrodo);

        //phoneBook.removePhoneNumber(new Human("", "", 0), frodoRemove);

        List<Human> actualHumans = phoneBook.getListOfHumansByPhoneNumber(frodoNotRemove);

        assertTrue(actualHumans.contains(frodo));
        //assertEquals(frodo, actualHuman);
    }

    @Test
    public void testAddPhoneNumber() {
        PhoneBook phoneBook = new PhoneBook();

        Human roman = new Human("Roman", "Fins", 17);
        String number = "123";

        phoneBook.addPhoneNumber(roman, number);

        List<String> list = phoneBook.getListOfPhoneNumbersByHuman(roman);

        boolean ok = list.contains(number);

        assertTrue(ok);
    }

    @Test
    public void testAddPhoneNumbersAndGetListOfPhoneNumbersByHuman() {
        PhoneBook phoneBook = new PhoneBook();

        Human roman = new Human("Roman", "Fins", 17);
        String
                number1 = "123",
                number2 = "427";
        List<String> numberList = new ArrayList<>();
        numberList.add(number1);
        numberList.add(number2);

        phoneBook.addPhoneNumbers(roman, numberList);

        List<String> list = phoneBook.getListOfPhoneNumbersByHuman(roman);

        assertEquals(numberList, list);
    }

    @Test
    public void testHumanByPhoneNumber1() {
        PhoneBook phoneBook = new PhoneBook();

        Human roman = new Human("Roman", "Fins", 17);
        String
                number1 = "123",
                number2 = "427";
        List<String> numberList = new ArrayList<>();
        numberList.add(number1);
        numberList.add(number2);

        phoneBook.addPhoneNumbers(roman, numberList);

        ArrayList<Human> expected = new ArrayList<>();
        expected.add(roman);

        assertEquals(expected, phoneBook.getListOfHumansByPhoneNumber(number1));
    }

    @Test
    public void testHumanByPhoneNumber2() {
        PhoneBook phoneBook = new PhoneBook();

        Human roman = new Human("Roman", "Fins", 17);
        String
                number1 = "123",
                number2 = "427";
        List<String> numberList = new ArrayList<>();
        numberList.add(number1);
        numberList.add(number2);

        assertNotEquals(roman, phoneBook.getListOfHumansByPhoneNumber(number1));
    }

    @Test
    public void testHumanByPhoneNumber3() {
        PhoneBook phoneBook = new PhoneBook();

        Human
                roman = new Human("Roman", "Fins", 17),
                frodo = new Human("Frodo", "Beggins", 37);

        String
                frodoRemove = "1213",
                frodoNotRemove = "3214",
                notInFrodo = "-";
        String[]
                frodoStr = {frodoRemove, frodoNotRemove, "12312"},
                romanStr = {"7567676", frodoRemove};
        String
                number1 = "123",
                number2 = "427";
        List<String> numberList = new ArrayList<>();
        numberList.add(number1);
        numberList.add(number2);

        //phoneBook.addPhoneNumbers(roman, numberList);

        assertNotEquals(roman, phoneBook.getListOfHumansByPhoneNumber(number1));
        //assertTrue(phoneBook.containsNumber(number1));
    }

    @Test
    public void testContainsNumber() {
        PhoneBook phoneBook = new PhoneBook();

        Human roman = new Human("Roman", "Fins", 17);
        String
                number1 = "123",
                number2 = "427";
        List<String> numberList = new ArrayList<>();
        numberList.add(number1);
        numberList.add(number2);

        phoneBook.addPhoneNumbers(roman, numberList);

        assertTrue(phoneBook.containsNumber(number1));
    }

    @Test
    public void testRemoveNumberAndNotContainsNumber() {
        PhoneBook phoneBook = new PhoneBook();

        Human roman = new Human("Roman", "Fins", 17);
        String
                number1 = "123",
                number2 = "427";
        List<String> numberList = new ArrayList<>();
        numberList.add(number1);
        numberList.add(number2);

        //phoneBook.addPhoneNumbers(roman, numberList);
        //phoneBook.removePhoneNumberOfHuman(roman, number1);

        phoneBook.removePhoneNumber(number1);

        //phoneBook.removeHuman(roman);
        //printCollectionToStdout(phoneBook.getListOfHumansByPhoneNumber(number1));
        //System.out.println(phoneBook.getListOfHumansByPhoneNumber(number1));

        //System.out.println(phoneBook.containsNumber(number1));
        //System.out.println(phoneBook.containsNumber(number2));

        assertFalse(phoneBook.containsNumber(number1));
    }

    @Test
    public void testRemoveNumberWhichIsNotInPhoneBook() {
        PhoneBook phoneBook = new PhoneBook();

        Human roman = new Human("Roman", "Fins", 17);
        String
                number1 = "123",
                number2 = "427";
        List<String> numberList = new ArrayList<>();
        numberList.add(number1);
        //numberList.add(number2);

        //phoneBook.addPhoneNumbers(roman, numberList);
        //phoneBook.removePhoneNumberOfHuman(roman, number1);

        phoneBook.removePhoneNumber(number2);

        //phoneBook.removeHuman(roman);
        //printCollectionToStdout(phoneBook.getListOfHumansByPhoneNumber(number1));
        //System.out.println(phoneBook.getListOfHumansByPhoneNumber(number1));

        //System.out.println(phoneBook.containsNumber(number1));
        //System.out.println(phoneBook.containsNumber(number2));

        assertFalse(phoneBook.containsNumber(number2));
    }

    @Test
    public void testRemoveHuman1() {
        PhoneBook phoneBook = new PhoneBook();

        Human roman = new Human("Roman", "Fins", 17);
        String
                number1 = "123",
                number2 = "427";
        List<String> numberList = new ArrayList<>();
        numberList.add(number1);
        numberList.add(number2);

        //phoneBook.addPhoneNumbers(roman, numberList);
        //phoneBook.removePhoneNumberOfHuman(roman, number1);

        //phoneBook.removePhoneNumber(number1);

        phoneBook.removeHuman(roman);
        //printCollectionToStdout(phoneBook.getListOfHumansByPhoneNumber(number1));
        //System.out.println(phoneBook.getListOfHumansByPhoneNumber(number1));

        //System.out.println(phoneBook.containsNumber(number1));
        //System.out.println(phoneBook.containsNumber(number2));

        assertFalse(phoneBook.containsHuman(roman));
    }

    @Test
    public void testRemoveHuman2() {
        PhoneBook phoneBook = new PhoneBook();

        Human roman = new Human("Roman", "Fins", 17);
        String
                number1 = "123",
                number2 = "427";
        List<String> numberList = new ArrayList<>();
        numberList.add(number1);
        numberList.add(number2);

        //phoneBook.addPhoneNumbers(roman, numberList);
        //phoneBook.removePhoneNumberOfHuman(roman, number1);

        //phoneBook.removePhoneNumber(number1);

        Human human2Remove = new Human("", "", 0);

        phoneBook.removeHuman(human2Remove);
        //printCollectionToStdout(phoneBook.getListOfHumansByPhoneNumber(number1));
        //System.out.println(phoneBook.getListOfHumansByPhoneNumber(number1));

        //System.out.println(phoneBook.containsNumber(number1));
        //System.out.println(phoneBook.containsNumber(number2));

        assertFalse(phoneBook.containsHuman(human2Remove));
    }

    @Test
    public void testRemoveNumberOfHuman() {
        PhoneBook phoneBook = new PhoneBook();

        Human roman = new Human("Roman", "Fins", 17);
        String
                number1 = "123",
                number2 = "427";
        List<String> numberList = new ArrayList<>();
        numberList.add(number1);
        numberList.add(number2);

        phoneBook.addPhoneNumbers(roman, numberList);
        phoneBook.removePhoneNumberOfHuman(roman, number1);

        //phoneBook.removePhoneNumber(number1);

        //phoneBook.removeHuman(roman);

        //printCollectionToStdout(phoneBook.getListOfPhoneNumbersByHuman(roman));
        //printCollectionToStdout(phoneBook.getListOfHumansByPhoneNumber(number1));

        //System.out.println(phoneBook.getListOfHumansByPhoneNumber(number2));

        //System.out.println(phoneBook.containsNumber(number1));
        //System.out.println(phoneBook.containsNumber(number2));

        assertFalse(phoneBook.haveThisHumanThisNumber(roman, number1));
    }
}

package app.collections.phone_book;

import app.collections.humans.Human;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    HashMap<Human, List<String>> bookNumbersByHuman;
    HashMap<String, Human> bookHumanByString;

    public PhoneBook() {
        bookNumbersByHuman = new HashMap<>();
        bookHumanByString = new HashMap<>();
    }

    public void addPhoneNumbers(Human human, List<String> phoneNumbers) {
        List<String> newList = phoneNumbers;
        if (bookNumbersByHuman.containsKey(human)) {
            newList.addAll(bookNumbersByHuman.get(human));
        }
        bookNumbersByHuman.put(human, newList);
        for (String elem : phoneNumbers) {
            bookHumanByString.put(elem, human);
        }
    }

    public void addPhoneNumber(Human human, String phoneNumber) {
        List<String> newList = new ArrayList<>();
        if (bookNumbersByHuman.containsKey(human)) {
            newList.addAll(bookNumbersByHuman.get(human));
        }
        newList.add(phoneNumber);
        bookNumbersByHuman.put(human, newList);
        bookHumanByString.put(phoneNumber, human);
    }

    public List<String> getListOfPhoneNumbersByHuman(Human human) {
        return bookNumbersByHuman.get(human);
    }

    public void removePhoneNumber(Human human, String phoneNumber) {
        bookNumbersByHuman.get(human).remove(phoneNumber);
        bookHumanByString.remove(phoneNumber);
    }

    public Human getHumanByPhoneNumber(String phoneNumber) {
        return bookHumanByString.get(phoneNumber);
    }
}

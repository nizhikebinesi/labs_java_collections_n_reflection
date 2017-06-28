package app.collections.phone_book;

import app.collections.humans.Human;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// 9
public class PhoneBook {
    private HashMap<Human, List<String>> Human2Number;
    private HashMap<String, List<Human>> Number2Human;

    public PhoneBook() {
        Human2Number = new HashMap<>();
        Number2Human = new HashMap<>();
    }

    public void addPhoneNumbers(Human human, List<String> phoneNumbers) {
        for (String phoneNumber : phoneNumbers) {
            addPhoneNumber(human, phoneNumber);
        }
    }

    public void addPhoneNumber(Human human, String phoneNumber) {
        ArrayList<Human> humans = new ArrayList<>();
        ArrayList<String> phoneNumbers = new ArrayList<>();
        if (Human2Number.containsKey(human)) {
            phoneNumbers.addAll(Human2Number.get(human));
            if (!phoneNumbers.contains(phoneNumber)) {
                phoneNumbers.add(phoneNumber);
                //Human2Number.remove(human);
                Human2Number.put(human, phoneNumbers);
            }
        } else {
            phoneNumbers.add(phoneNumber);
            Human2Number.put(human, phoneNumbers);
        }

        if (Number2Human.containsKey(phoneNumber)) {
            humans.addAll(Number2Human.get(phoneNumber));
            if (!humans.contains(human)) {
                humans.add(human);
                //Number2Human.remove(phoneNumber);
                Number2Human.put(phoneNumber, humans);
            }
        } else {
            humans.add(human);
            Number2Human.put(phoneNumber, humans);
        }
    }

    public void removePhoneNumberOfHuman(Human human, String phoneNumber) {
        if (Number2Human.containsKey(phoneNumber) && Human2Number.containsKey(human)) {
            ArrayList<String> phoneNumbers = new ArrayList<>(Human2Number.get(human));
            Human2Number.remove(human);
            phoneNumbers.remove(phoneNumber);
            if (phoneNumbers.size() > 0) {
                Human2Number.put(human, phoneNumbers);
            }

            ArrayList<Human> humans = new ArrayList<>(Number2Human.get(phoneNumber));
            Number2Human.remove(phoneNumber);
            humans.remove(human);
            if (humans.size() > 0) {
                Number2Human.put(phoneNumber, humans);
            }
        }
    }

    public void removePhoneNumber(String phoneNumber) {
        if (Number2Human.containsKey(phoneNumber)) {
            ArrayList<Human> humans = new ArrayList<>(Number2Human.get(phoneNumber));
            for (Human human : humans) {
                ArrayList<String> phoneNumbers = new ArrayList<>(Human2Number.get(human));
                Human2Number.remove(human);
                phoneNumbers.remove(phoneNumber);
                if (phoneNumbers.size() > 0) {
                    Human2Number.put(human, phoneNumbers);
                }
            }
            Number2Human.remove(phoneNumber);
        }
    }

    public void removeHuman(Human human) {
        if (Human2Number.containsKey(human)) {
            ArrayList<String> phoneNumbers = new ArrayList<>(Human2Number.get(human));
            for (String phoneNumber : phoneNumbers) {
                ArrayList<Human> humans = new ArrayList<>(Number2Human.get(phoneNumber));
                Number2Human.remove(phoneNumber);
                humans.remove(human);
                if (humans.size() > 0) {
                    Number2Human.put(phoneNumber, humans);
                }
            }
            Human2Number.remove(human);
        }
    }

    public List<Human> getListOfHumansByPhoneNumber(String phoneNumber) {
        return Number2Human.get(phoneNumber);
    }

    public List<String> getListOfPhoneNumbersByHuman(Human human) {
        return Human2Number.get(human);
    }

    public boolean containsHuman(Human human) {
        return Human2Number.containsKey(human);
    }

    public boolean containsNumber(String phoneNumber) {
        return Number2Human.containsKey(phoneNumber);
    }

    public boolean haveThisHumanThisNumber(Human human, String phoneNumber) {
        return Human2Number.containsKey(human) && Number2Human.containsKey(phoneNumber) && Number2Human.get(phoneNumber).contains(human);
    }
}

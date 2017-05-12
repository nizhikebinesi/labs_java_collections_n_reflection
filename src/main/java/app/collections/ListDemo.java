package app.collections;

import app.collections.humans.Human;
import app.collections.humans.name.Name;
import app.collections.humans.name.NameComparator;

import java.util.*;

public class ListDemo {
    public static <T> void printCollectionToStdout(Collection<T> list) {
        for (T elem : list) {
            System.out.println(elem + "; ");
        }
    }

    // 1
    public static int countOfStringWhoseFirstSymbolIsEqualToReal(
            List<String> strings,
            char symbol
    ) {
        int counter = 0, id = 0;
        for (String string : strings) {
            if (string.charAt(id) == symbol) {
                counter++;
            }
        }
        return counter;
    }

    // 2
    public static <T extends Human> int countOfEqualLastNames(
            List<T> humans,
            T human
    ) {
        int counter = 0;
        for (T anotherHuman : humans) {
            if (anotherHuman.getLastName().equals(human.getLastName())) {
                counter++;
            }
        }
        return counter;
    }

    // 3
    public static <T extends Human> List<T> listWithoutOneHuman(
            List<T> list, T human
    ) {
        List<T> newList = new ArrayList<T>();
        for (T elem : list) {
            if (!elem.equals(human)) {
                newList.add(elem);
            }
        }
        return newList;
    }

    // 4
    public static int countOfNotIntersectedSets(
            List<Set<Integer>> integers,
            Set<Integer> integer
    ) {
        int counter = 0;
        for (Set<Integer> set : integers) {
            int size = set.size();
            boolean ok;
            ok = set.retainAll(integer) && set.size() == 0;
            counter = ok ? + 0 : + 1;
        }
        return counter;
    }

    // 5
    public static <T extends Human> Set<T> setOfMaxAgePeople(
            List<T> humans
    ) {
        int max = 0;
        Set<T> set = new HashSet<>();
        for (T elem : humans) {
            max = Math.max(max, elem.getAge());
        }
        for (T elem : humans) {
            if (elem.getAge() == max) {
                set.add(elem);
            }
        }
        return set;
    }

    // 6
    // like TreeSort
    public static <T extends Human> List<T> listOfHumanByLexicographicalFIO(
            Set<T> set
    ) {
        ArrayList<T> list = new ArrayList<>();
        TreeMap<Name, T> sorting = new TreeMap<Name, T>(new NameComparator());
        for (T elem : set) {
            sorting.put(elem.getName(), elem);
        }
        for (Map.Entry<Name, T> entry : sorting.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }

    // 7
    public static <T extends Human> Set<T> setOfHumansWithIdInSet(
            Map<Integer, T> humanWithId, Set<Integer> idSet
    ) {
        Set<T> set = new HashSet<T>();
        for (Map.Entry<Integer, T> entry : humanWithId.entrySet()) {
            if (idSet.contains(entry.getKey())) {
                set.add(entry.getValue());
            }
        }
        return set;
    }

    // 8
    public static <T extends Human> List<Integer> listOfIdsPeopleWhichAgeIsMoreThan18(
            Map<Integer, T> humanWithId
    ) {
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, T> entry : humanWithId.entrySet()) {
            if (entry.getValue().getAge() >= 18) {
                list.add(entry.getKey());
            }
        }
        return list;
    }
}

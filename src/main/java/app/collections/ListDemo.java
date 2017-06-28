package app.collections;

import app.collections.humans.Human;
import app.collections.humans.HumanComparator;
import app.collections.humans.name.Name;
import app.collections.humans.name.NameComparator;

import java.util.*;

public class ListDemo {
    public static <T> void printCollectionToStdout(Collection<T> list) {
        if (list == null) {
            System.out.println(list);
            return;
        }
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
            //if (Character.toLowerCase(string.charAt(id)) == Character.toLowerCase(symbol)) {
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
    ) /*throws NullPointerException*/ {
        /*if (human.getLastName() == null) {
            throw new NullPointerException("Last name of human = " + human + "; lastName = " + human.getLastName());
        }*/
        int counter = 0;
        for (T anotherHuman : humans) {
            if (human.getLastName().equals(anotherHuman.getLastName())) {
                counter++;
            }
        }
        return counter;
    }

    // 3
    public static <T extends Human> List<T> listWithoutOneHuman(
            List<T> list, T human
    ) throws CloneNotSupportedException {
        List<T> newList = new ArrayList<T>();
        for (T elem : list) {
            if (!elem.equals(human)) {
                newList.add((T) elem.clone());
            }
        }
        return newList;
    }

    // -
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

    // 4
    public static List<Set<Integer>> listOfNotIntersectedSets(
            List<Set<Integer>> integers,
            Set<Integer> integer
    ) {
        //LinkedList<Set<Integer>> removeCandidates = new LinkedList<>();
        /*for (Set<Integer> set : integers) {
            if (set.retainAll())
        }*/
        //System.out.println();
        for (ListIterator<Set<Integer>> it = integers.listIterator(); it.hasNext(); ) {
            Set<Integer> elem = new HashSet<>(it.next());
            int size = elem.size();
            elem.retainAll(integer);
            boolean ok = /*elem.retainAll(integer) &&*/ elem.size() > 0 && elem.size() <= size;
            //System.out.println("ok = " + ok);
            if (ok) {
                //System.out.println("Here");
                it.remove();
            }
            //printCollectionToStdout(elem);
        }
        //System.out.println();*/
        //integers.removeIf(elem -> elem.retainAll(integer));
        return integers;
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
        TreeSet<T> treeSet = new TreeSet<T>(new HumanComparator<T>());
        treeSet.addAll(set);
        ArrayList<T> list = new ArrayList<>();
        list.addAll(treeSet);
       /*TreeMap<Name, T> sorting = new TreeMap<Name, T>(new NameComparator());
        for (T elem : set) {
            sorting.put(elem.getName(), elem);
        }
        for (Map.Entry<Name, T> entry : sorting.entrySet()) {
            list.add(entry.getValue());
        }*/
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

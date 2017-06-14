package app.collections;

import app.collections.humans.Human;
import app.collections.humans.HumanComparator;
import app.collections.humans.Student;
import app.collections.humans.name.NameComparator;
import app.collections.phone_book.PhoneBook;
import org.junit.Test;

import java.util.*;

import static app.collections.ListDemo.*;
import static java.lang.Math.random;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TestListDemo {
    // create array of Humans for test
    private static Human[] createHumansArray(String ... args) {
        if (args.length % 3 != 0) {
            throw new IllegalArgumentException("Count of args must be 3*n, where n is natural number");
        }
        Human[] humans = new Human[args.length / 3];
        for (int i = 0; i < args.length; i += 3) {
            humans[i / 3] = new Human(args[i], args[i + 1], args[i + 2], 0/*(int) (random() % 110)*/);
        }
        return  humans;
    }

    private static String[] createStringArray(String ... args) {
        String[] strings = new String[args.length];
        int i = 0;
        for (String s : args) {
            strings[i++] = s;
        }
        return strings;
    }

    private static Set<Integer> createIntegerSet(int N, boolean haveIntersect) {
        HashSet<Integer> set = new HashSet<>();
        if (haveIntersect) {
            set.add(42);
            N--;
        }
        for (int i = 0; i < N; i++) {
            if (haveIntersect) {
                set.add(-((int) (random() % 517 + 1)));
            }  else {
                set.add(i + 1);
            }
        }
        return set;
    }

    // 1
    @Test
    public void testCountOfStringWhoseFirstSymbolIsEqualToReal() {
        //Human[] humans = new Human[5];
        char ch = 'F';
        /*ArrayList<Human> humans = new ArrayList<>();
        humans.addAll(
                Arrays.asList(
                        createHumansArray(
                                 "Vanya", "Vronsky", "Ivanov",
                                        "Vadim", "G", "Jones", "Gennadiy",
                                        "John", "Son", "Smith"
                        )));
        int actual = countOfStringWhoseFirstSymbolIsEqualToReal(humans, ch);*/
        List<String> strings = Arrays.asList(new String[]{"First", "Second", "Ford", "Vannadiy"});
        int
                actual = countOfStringWhoseFirstSymbolIsEqualToReal(strings, ch),
                expected = 2;
        assertEquals(expected, actual);
    }

    // 2
    @Test
    public void testCountOfEqualLastNames() {
        ArrayList<Human> humans = new ArrayList<>();
        humans.addAll(Arrays.asList(createHumansArray(
                 "Req", "Vasyly", "Vernik",
                        "Gendy", "-", "Tarkovsy",
                        "Vanga", "-", "Vernik"
        )));
        //printCollectionToStdout(humans);
        Human human = new Human("John", "Vernik", 42);
        int actual = countOfEqualLastNames(humans, human),
            expected = 2;
        //System.out.println(actual);
        assertEquals(expected, actual);
    }

    // 3
    @Test
    public void testListWithoutOneHuman() {
        Human human = new Human("Req", "Vasyly", "Vernik", 0);
        ArrayList<Human> humans = new ArrayList<>();
        humans.addAll(Arrays.asList(createHumansArray(
                "Req", "Vasyly", "Vernik",
                "Gendy", "-", "Tarkovsy",
                "Vanga", "-", "Vernik"
        )));
        List<Human> actual = listWithoutOneHuman(humans, human),
                    expected = Arrays.asList(createHumansArray(
                            "Gendy", "-", "Tarkovsy",
                            "Vanga", "-", "Vernik"
                    ));
        // для больших списков лучше использовать assertThat
        assertArrayEquals(actual.toArray(), expected.toArray());
    }

    // 4
    @Test
    public void testListOfNotIntersectedSets() {
        int N = 5;
        List<Set<Integer>> setList = new ArrayList<>();
        Set<Integer> set = createIntegerSet(3, true);
        for (int i = 0; i < N; i++) {
            setList.add(createIntegerSet(/*i+*/2/*(int)(random() % 10)*/, ((i + 1) % 2 == 0)));
            /*System.out.println("i = " + i);
            printCollectionToStdout(setList.get(i));
            System.out.println();*/
        }
        /*System.out.println();
        printCollectionToStdout(set);*/
        List<Set<Integer>> actualList = listOfNotIntersectedSets(setList, set);
        /*for (Set<Integer> s : actualList) {
            System.out.println("---");
            printCollectionToStdout(s);
            System.out.println("---");
        }*/
        int     actual = actualList.size(),
                expected = 3;
        assertEquals(expected, actual);
        // для больших коллекций лучше использовать assertThat
        //assertArrayEquals();
    }

    // 5
    @Test
    public void testSetOfMaxAgePeople() {
        List<Human> humans = new ArrayList<>();
        Human
                a = new Human("V", "W", 132),
                b = new Human("K", "qw", "A", 12),
                c = new Student("ew", "L", 0);
        humans.add(a);
        humans.add(b);
        humans.add(c);
        Set<Human>
                actual = setOfMaxAgePeople(humans),
                expected = new HashSet<>();
        expected.add(a);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    private static List<Human> sortCollectionOfHumanByLexicograficalFIOOrder(List<Human> humans) {
        humans.sort(new HumanComparator<Human>());
        return humans;
    }

    // 6
    @Test
    public void testListOfHumanByLexicographicalFIO() {
        Set<Human> humans = new HashSet<>();
        humans.add(new Human("Vasya", "Pupkin", 45));
        humans.add(new Student("Vasya", "Junior","Pupkin", 4));
        humans.add(new Human("Katrin", "Zeta", "NotJones", 37));
        humans.add (new Human("Gennadiy", "Vasil'evich", "Voronkov", 23));

        List<Human> listOfHumans = listOfHumanByLexicographicalFIO(humans);

        List<Human> list = new ArrayList<>();
        list.addAll(humans);

        Object[]
                expected = sortCollectionOfHumanByLexicograficalFIOOrder(list).toArray(),
                actual = listOfHumans.toArray();
        //System.out.println(Arrays.toString(actual));
        //System.out.println(expected);
        assertArrayEquals(expected, actual);
    }

    // 7
    @Test
    public void testSetOfHumansWithIdInSet() {
        Map<Integer, Human> map = new HashMap<>();

        Human
                roman = new Human("Roman", "Fins", 17),
                frodo = new Human("Frodo", "Beggins", 37);
        map.put(42, frodo);
        map.put(12, roman);
        Set<Integer> set = new HashSet<>();
        set.add(42);

        Set<Human>
                actualSet = setOfHumansWithIdInSet(map, set),
                expectedSet = new HashSet<>();

        expectedSet.add(frodo);

        assertArrayEquals(expectedSet.toArray(), actualSet.toArray());
    }

    // 8
    @Test
    public void testListOfIdsPeopleWhichAgeIsMoreThan18() {
        Map<Integer, Human> map = new HashMap<>();

        Human
                roman = new Human("Roman", "Fins", 17),
                frodo = new Human("Frodo", "Beggins", 37);
        map.put(42, frodo);
        map.put(12, roman);

        List<Integer>
                actual = listOfIdsPeopleWhichAgeIsMoreThan18(map),
                expected = new ArrayList<>();
        expected.add(42);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}

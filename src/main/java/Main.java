import app.collections.ListDemo;
import app.collections.humans.Human;
import app.collections.humans.Student;

import java.util.*;

import static app.collections.ListDemo.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Set<Integer>> integers = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(42);
        set1.add(13);
        set1.add(27);
        HashSet<Integer> set2 = new HashSet<>();
        set2.add(13);
        integers.add(set1);
        System.out.println(ListDemo.countOfNotIntersectedSets(integers, set2));

        Set<Human> humans = new HashSet<>();
        humans.add(new Human("Vasya", "Pupkin", 45));
        humans.add(new Student("Vasya", "Junior","Pupkin", 4));
        humans.add(new Human("Katrin", "Zeta", "NotJones", 37));
        humans.add (new Human("Gennadiy", "Vasil'evich", "Voronkov", 23));

        List<Human> listOfHumans = listOfHumanByLexicographicalFIO(humans);

        printCollectionToStdout(listOfHumans);

        Map<Integer, Student> map = new HashMap<>();
        map.put(42, new Student("Frodo", "Beggins", 37, "IMIT"));
        map.put(12, new Student("Roman", "Fins", 17, "FIMT"));
        Set<Integer> set = new HashSet<>();
        set.add(42);
        Set<Student> students = setOfHumansWithIdInSet(map, set);

        System.out.println();
        printCollectionToStdout(students);



        //LinkedHashSet<Integer> tree = new LinkedHashSet<>();
        //Class arr = tree.getClass().getSuperclass();
        //System.out.println(Object.class.getSuperclass());
    }
}

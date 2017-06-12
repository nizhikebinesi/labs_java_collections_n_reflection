package app.reflection;

import app.collections.humans.Human;
import app.collections.humans.Student;
import app.reflection.executable.ExecOne;
import app.reflection.executable.ExecThree;
import app.reflection.executable.ExecTwo;
import app.reflection.executable.Executable;
import org.junit.Test;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

import static app.collections.ListDemo.printCollectionToStdout;
import static app.reflection.ReflectionDemo.*;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class TestReflectionDemo {
    // 11
    @Test
    public void testCountOfListElementsWhichIsHumanOrHisDescendant() {
        Object
                human = new Human("Vasya", "Pupkin", 23),
                integer = 45,
                student = new Student("Petr", "Petrov", 21, "EE Faculty")
        ;
        List<Object> list = new ArrayList<>();
        list.add(human);
        list.add(integer);
        list.add(student);
        int
                actual = countOfListElementsWhichIsHumanOrHisDescendant(list),
                expected = 2;
        assertEquals(expected, actual);
    }

    // 12
    @Test
    public void testGetListOfPublicMethodsOfObjectNames() {
        Human human = new Human("", "", 41);
        String expectedArr[] = {
                "equals",
                "getAge",
                "getClass",
                "getFirstName",
                "getLastName",
                "getName",
                "getSecondName",
                "hashCode",
                "notify",
                "notifyAll",
                "setAge",
                "setFirstName",
                "setLastName",
                "setName",
                "setSecondName",
                "toString",
                "wait"
        };
        List<String>
                expected = Arrays.asList(expectedArr),
                actual = getListOfPublicMethodsOfObjectNames(human);
        assertEquals(expected, actual);
        //printCollectionToStdout(getListOfPublicMethodsOfObjectNames(human));
    }

    // 13
    @Test
    public void testListOfSuperClassesNamesOfThisObjectNames1() {
        String expectedArray[] = {
                "app.collections.humans.Human",
                "java.lang.Object"
        };
        List<String>
                expected = Arrays.asList(expectedArray),
                actual = listOfSuperClassesNamesOfThisObjectNames(
                        new Student("", "", 0, ""
                        )
                );
        /*printCollectionToStdout(
                listOfSuperClassesNamesOfThisObjectNames(
                        new Student("", "", 0, ""
                        )
                )
        );*/
        assertEquals(expected, actual);
    }

    // 13
    @Test
    public void testListOfSuperClassesNamesOfThisObjectNames2() {
        String expectedArray[] = {
                "java.util.HashSet",
                "java.util.AbstractSet",
                "java.util.AbstractCollection",
                "java.lang.Object"
        };
        List<String>
                expected = Arrays.asList(expectedArray),
                actual = listOfSuperClassesNamesOfThisObjectNames(
                        new LinkedHashSet<>()
                );
        /*printCollectionToStdout(
                listOfSuperClassesNamesOfThisObjectNames(
                        new LinkedHashSet<>()
                )
        );*/
        assertEquals(expected, actual);
    }

    // 14
    @Test
    public void testCountOfExecutableObjectsAndExecuteIt() {
        Object
                exec1 = new ExecOne(),
                exec2 = new ExecTwo(),
                exec3 = new ExecThree(),
                integer = 42;
        Object[] objects = {exec1, exec2, exec3, integer};
        List<Object> list = Arrays.asList(objects);
        int
                expected = 3,
                actual = countOfExecutableObjectsAndExecuteIt(list);
        //System.out.println("c = " + c);
        int
                actualAExec1 = ((ExecOne) exec1).getA(),
                expectedAExec1 = -21;
        Human
                actualHumanExec2 = ((ExecTwo) exec2).getHuman(),
                expectedHumanExec2 = new Human("Vadim", "Sokolov", 123);
        String
                actualStringExec2 = ((ExecTwo) exec2).getS(),
                expectedStringExec2 = "name = Sokolov Vadim; age = 123; this is string!";
        double
                actualAExec3 = ((ExecThree) exec3).getA(),
                expectedAExec3 = 0.0;

        assertTrue(
                (actualAExec1 == expectedAExec1)
                && (actualAExec3 == expectedAExec3)
                && (actualHumanExec2.equals(expectedHumanExec2))
                && (actualStringExec2.equals(expectedStringExec2))
                && (actual == expected)
        );
    }

    // 15
    @Test
    public void testGetListOfGettersAndSetters() {
        Human human = new Human("", "", 21);

        String[] arr = {
                "getName",
                "setName",
                "setFirstName",
                "setLastName",
                "setSecondName",
                "getSecondName",
                "getFirstName",
                "setAge",
                "getAge",
                "getLastName"
        };

        List<String>
                expectedList = Arrays.asList(arr),
                actualList = getListOfGettersAndSetters(human);
        Set<String>
                expected = new HashSet<>(expectedList),
                actual = new HashSet<>(actualList);

        assertEquals(expected, actual);
    }
}

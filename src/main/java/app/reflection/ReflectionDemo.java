package app.reflection;

import app.collections.humans.Human;
import com.sun.istack.internal.NotNull;

import java.lang.reflect.Executable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

import static app.collections.ListDemo.printCollectionToStdout;


public class ReflectionDemo {
    /**
     * 11. Дан список объектов произвольных типов.
     * Найдите количество элементов списка,
     * которые являются объектами типа Human или его подтипами.
     * @param list of any types objects
     * @param <T> is type or list
     * @return count of list which is object of Human.class or his descendant
     */
    public static <T> int countOfListElementsWhichIsHumanOrHisDescendant(List<T> list) {
        int counter = 0;
        for (T elem : list) {
            if (elem instanceof Human) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * 12. Для объекта получить список имен его открытых методов.
     * @param object for exercise
     * @param <T> is type of this object
     * @return list of names
     */
    public static <T> List<String> getListOfPublicMethodsOfObjectNames(T object) {
        //List<Method> list = new ArrayList<>();
        //object.getClass().getMethods();
        Method[] methods = object.getClass().getMethods();
        Set<String> set = new TreeSet<>();
        for (Method method : methods) {
            set.add(method.getName());
        }
        return new ArrayList<>(set);
    }

    /**
     *
     * @param clazz
     * @return
     */
    private static boolean conditionForListOfSuperClassesNamesOfThisObjectNames(Class clazz) {
        return clazz != null;
    }

    /**
     * 13. Для объекта получить список
     * (в виде списка строк) имен всех
     * его суперклассов до класса Object включительно.
     * @param object for exercise
     * @param <T> is type of object
     * @return list of super classes names of this object names
     */
    public static <T> List<String> listOfSuperClassesNamesOfThisObjectNames(T object) {
        List<String> list = new ArrayList<>();
        Class clazz = object.getClass().getSuperclass();
        while (conditionForListOfSuperClassesNamesOfThisObjectNames(clazz)) {
            list.add(clazz.getCanonicalName());
            clazz = clazz.getSuperclass();
        }
        return list;
    }

    /**
     *
     * @param set
     * @return
     */
    private static boolean conditionForCountOfExecutableObjectsAndExecuteIt(Set<Class> set) {
        /*System.out.println("Some = " + (app.reflection.executable.Executable.class));

        printCollectionToStdout(set);

        System.out.println("cond = " + set.contains((app.reflection.executable.Executable.class)));
        */
        return set.contains((app.reflection.executable.Executable.class));
    }

    /**
     * 14. Напишите метод, который для списка
     * объектов находит его элементы, реализующие
     * этот интерфейс, и выполняет в таких объектах
     * метод execute(). Метод возвращает количество
     * найденных элементов.
     * @param objects
     * @param <T>
     * @return
     */
    public static <T> int countOfExecutableObjectsAndExecuteIt(List<T> objects) {
        int counter = 0;
        for (T object : objects) {
            HashSet<Class> set = new HashSet<>();
            set.addAll(Arrays.asList(object.getClass().getInterfaces()));
            if (conditionForCountOfExecutableObjectsAndExecuteIt(set)) {
                try {
                    Method method = object.getClass().getMethod("execute");
                    method.invoke(object);
                    counter++;
                } catch (NoSuchMethodException e) {
                    System.err.println("Object = " + object +
                            " has not method execute. Exception = " + e);
                } catch (IllegalAccessException e) {
                    System.err.println("Object = " + object +
                            " has method execute but illegal access. Exception = " + e);
                } catch (InvocationTargetException e) {
                    System.err.println("In object = " + object +
                            " Exception = " + e);
                }
            }
        }
        return counter;
    }

    private static String   staticString = "static",
                            publicString = "public",
                            voidString = "void",
                            getString = "get",
                            setString = "set";

    private static Class voidClass = void.class;

    /**
     * 15. Для объекта получить список
     * его геттеров и сеттеров (в виде списка строк).
     * Геттером считаем открытый нестатический метод
     * без параметров, значение которого не void, а
     * имя начинается с get. Сеттером считаем открытый
     * нестатический метод с одним параметром,
     * с результатом типа void, а имя метода
     * начинается с set.
     * @param object
     * @param <T>
     * @return
     */
    public static <T> List<String> getListOfGettersAndSetters(T object) {
        List<String> gettersAndSetters = new ArrayList<>();
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            String methodName = method.getName();
            if ((!Modifier.isStatic(modifiers))&&(Modifier.isPublic(modifiers))) {
                if (methodName.startsWith(getString)) {
                    if (!voidClass.equals(method.getReturnType()) && method.getParameterCount() == 0) {
                        gettersAndSetters.add(method.getName());
                    }
                } else if (methodName.startsWith(setString)) {
                    if (voidClass.equals(method.getReturnType()) && method.getParameterCount() == 1) {
                        gettersAndSetters.add(method.getName());
                    }
                }
            }
        }
        return gettersAndSetters;
    }
}

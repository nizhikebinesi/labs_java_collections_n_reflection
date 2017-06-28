package app.collections.humans;

import app.collections.humans.name.Name;
import app.collections.humans.name.NameComparator;

import java.util.Comparator;

/**
 * Created by 1 on 11.06.2017.
 */
public class HumanComparator<T extends Human> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        Name
                name1 = o1.getName(),
                name2 = o2.getName();
        return (new NameComparator()).compare(name1, name2);
    }
}

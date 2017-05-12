package app.collections.humans.name;

import java.util.Comparator;

/**
 * Created by 1 on 12.05.2017.
 */
public class NameComparator implements Comparator<Name> {
    @Override
    public int compare(Name o1, Name o2) {
        String  firstName1 = o1.getFirstName(),
                firstName2 = o2.getFirstName(),
                secondName1 = o1.getSecondName(),
                secondName2 = o2.getSecondName(),
                lastName1 = o1.getLastName(),
                lastName2 = o2.getLastName();
        return (
                // if lastName
                lastName1.compareTo(lastName2) != 0 ?
                lastName1.compareTo(lastName2) :
                // if firstName
                (firstName1.compareTo(firstName2) != 0 ?
                firstName1.compareTo(firstName2) :
                // if secondName
                secondName1.compareTo(secondName2)
                )
        ) ;
    }
}

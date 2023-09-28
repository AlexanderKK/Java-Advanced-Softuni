package _09IteratorsAndComparators._02Exercise._07EqualityLogic;

import java.util.Comparator;

public class HashSetComparator implements Comparator<Person> {

    @Override
    public int compare(Person f, Person s) {
        int result = f.name().compareTo(s.name());

        return result != 0
                ? result
                : Integer.compare(f.age(), s.age());
    }
}

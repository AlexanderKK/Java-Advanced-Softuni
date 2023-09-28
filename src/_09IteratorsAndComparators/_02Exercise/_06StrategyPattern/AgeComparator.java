package _09IteratorsAndComparators._02Exercise._06StrategyPattern;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person f, Person s) {
        return Integer.compare(f.age(), s.age());
    }
}

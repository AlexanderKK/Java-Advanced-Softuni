package _09IteratorsAndComparators._02Exercise._06StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person f, Person s) {
        int result = Integer.compare(f.name().length(), s.name().length());
        if(result == 0) {
            char ch1 = Character.toUpperCase(f.name().charAt(0));
            char ch2 = Character.toUpperCase(s.name().charAt(0));

            result = Character.compare(ch1, ch2);
        }

        return result;
    }
}

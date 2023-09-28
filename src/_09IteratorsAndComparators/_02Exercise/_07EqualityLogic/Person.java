package _09IteratorsAndComparators._02Exercise._07EqualityLogic;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %d", name, age);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        hash = 31 * hash + age;

//        System.out.println("hashCode() called - Computed hash: " + hash);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(obj == null) {
            return false;
        }

        if(this.getClass() != obj.getClass()) {
            return false;
        }

        Person person = (Person) obj;

        return name.equals(person.name) && age == person.age;
    }

    @Override
    public int compareTo(Person other) {
        int result = name.compareTo(other.name);

        return result != 0
                ? result
                : Integer.compare(age, other.age);
    }
}

package _06DefiningClasses._02Exercise._07Google;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemons = new ArrayList<>();
    private List<Parent> parents = new ArrayList<>();
    private List<Child> children = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "\n" +
                "Company:" + (company == null ? "" : "\n" + company) +
                "\nCar:" + (car == null ? "" : "\n" + car) +
                "\nPokemon:" + (pokemons.size() == 0 ? "" : "\n" + pokemons.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator()))) +
                "\nParents:" + (parents.size() == 0 ? "" : "\n" + parents.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator()))) +
                "\nChildren:" + (children.size() == 0 ? "" : "\n" + children.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator())));
    }
}

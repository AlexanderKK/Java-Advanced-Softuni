package _06DefiningClasses._02Exercise._06PokemonTrainer;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String name() {
        return name;
    }

    public String element() {
        return element;
    }

    public int health() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}

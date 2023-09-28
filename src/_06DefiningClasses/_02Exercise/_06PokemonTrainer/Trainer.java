package _06DefiningClasses._02Exercise._06PokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.pokemons = pokemons;
    }

    public String name() {
        return name;
    }

    public List<Pokemon> pokemons() {
        return pokemons;
    }

    public int badges() {
        return badges;
    }

    public void searchPokemon(String element) {
        int count = (int) pokemons.stream()
                .filter(p -> p.element().equals(element))
                .count();

        if(count == 0) {
            for (int i = 0; i < pokemons.size(); i++) {
                Pokemon pokemon = pokemons.get(i);

                pokemon.setHealth(pokemon.health() - 10);

                if (pokemon.health() <= 0) {
                    pokemons.remove(pokemon);
                    i--;
                }
            }
        } else {
            badges++;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", name, badges, pokemons.size());
    }
}

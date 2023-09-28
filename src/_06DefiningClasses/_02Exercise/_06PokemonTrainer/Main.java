package _06DefiningClasses._02Exercise._06PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Trainer> trainers = new ArrayList<>();

        String command;
        while(!"Tournament".equals(command = scanner.nextLine())) {
            String[] data = command.split(" ");

            String trainerName = data[0];
            String pokemonName = data[1];
            String element = data[2];
            int health = Integer.parseInt(data[3]);

            boolean trainerExists = trainers.stream()
                    .anyMatch(t -> t.name().equals(trainerName));

            if(!trainerExists) {
                Trainer trainer = new Trainer(trainerName, new ArrayList<>());
                trainers.add(trainer);
            }

            Trainer currentTrainer = trainers.stream()
                    .filter(t -> t.name().equals(trainerName))
                    .findFirst()
                    .get();

            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            currentTrainer.pokemons().add(pokemon);
        }

        while(!"End".equals(command = scanner.nextLine())) {
            String element = command;

            trainers.forEach(t -> t.searchPokemon(element));
        }

        trainers.stream()
                .sorted((first, second) -> {
                    int result = Integer.compare(second.badges(), first.badges());
                    return result;
//                    if(result != 0) {
//                        return result;
//                    } else {
//                        return first.name().compareTo(second.name());
//                    }
                })
                .forEach(System.out::println);
    }
}

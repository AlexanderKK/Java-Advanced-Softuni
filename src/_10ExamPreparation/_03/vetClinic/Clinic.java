package _10ExamPreparation._03.vetClinic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public int getCount() {
        return data.size();
    }

    public void add(Pet pet) {
        boolean isPresent = data.stream().anyMatch(e -> e.name().equals(pet.name()) && e.owner().equals(pet.owner()));

        if(!isPresent && getCount() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(e -> e.name().equals(name));

//        boolean isPresent = data.stream()
//                .anyMatch(e -> e.name().equals(name));
//
//        if(isPresent) {
//            Pet pet = data.stream().filter(e -> e.name().equals(name)).findFirst().get();
//            data.remove(pet);
//
//            return true;
//        }
//
//        return false;
    }

    public Pet getPet(String name, String owner) {
        return data.stream()
                .filter(e -> e.name().equals(name) && e.owner().equals(owner))
                .findAny()
                .orElse(null);

//        for (Pet pet : data) {
//            if(pet.name().equals(name) && pet.owner().equals(owner)) {
//                return pet;
//            }
//        }
//
//        return null;
    }

    private static int comparing(Pet f, Pet s) {
        return f.age() - s.age();
    }

    public Pet getOldestPet() {
        return Collections.max(data, Comparator.comparingInt(Pet::age));

//        Pet oldestPet = data.stream().max(Clinic::comparing).get();
//
//        return oldestPet;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("The clinic has the following patients:");
        sb.append(System.lineSeparator());

        data.forEach(e -> sb.append(String.format("%s %s", e.name(), e.owner())).append(System.lineSeparator()));

        return sb.toString();
    }
}

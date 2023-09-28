package _09IteratorsAndComparators._02Exercise._08PetClinics2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Clinic {
    private String name;
    private List<Pet> rooms;
    private int indexLeft;
    private int indexRight;
    private int indexRemove;
    private int petsCount;

    public Clinic(String name, int capacity) {
        this.name = name;
        this.rooms = fillRooms(capacity);
        this.indexLeft = this.indexRight = this.indexRemove = capacity / 2;
    }

    public String name() {
        return name;
    }

    public List<Pet> fillRooms(int capacity) {
        List<Pet> rooms = new ArrayList<>();

        for (int i = 0; i < capacity; i++) {
            rooms.add(i, null);
        }

        return rooms;
    }

    public boolean add(Pet pet) {
        int currentIndex;

        if(rooms.stream().allMatch(Objects::isNull)) {
            currentIndex = rooms.size() / 2;
        } else {
            if(petsCount % 2 != 0) {
                currentIndex = --indexLeft;
            } else {
                currentIndex = ++indexRight;
            }
        }

        if(checkIndex(currentIndex)) {
            rooms.set(currentIndex, pet);

            petsCount++;

            return true;
        }

        return false;
    }

    public boolean remove() {
        int currentIndex;

        if(rooms.stream().allMatch(Objects::isNull)) {
            return false;
        } else {
            if(indexRemove == rooms.size()) {
                indexRemove = 0;
            }

//            if(indexRemove > rooms.size() / 2 || indexRemove < rooms.size() / 2) {
//                indexRemove++;
//            }
        }

        currentIndex = indexRemove;

        if(checkIndex(currentIndex)) {
            rooms.set(currentIndex, null);

            indexRemove++;
            petsCount--;

            return true;
        }

        return false;
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index < rooms.size();
    }

    public int size() {
        return rooms.size();
    }

    public boolean isEmpty() {
        return rooms.size() == 0;
    }
}

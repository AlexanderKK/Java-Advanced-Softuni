package _09IteratorsAndComparators._02Exercise._08PetClinics;

import java.util.HashMap;
import java.util.Map;

public class Clinic {
    private String name;
    private int capacity;
    private Map<Integer, Pet> rooms;

    public Clinic(String name, int capacity) throws Exception {
        this.name = name;
        setCapacity(capacity);
        rooms = new HashMap<>();

        for (int i = 1; i <= capacity; i++) {
            rooms.put(i, null);
        }
    }

    public void setCapacity(int capacity) throws Exception {
        if (capacity % 2 == 0) {
            throw new Exception("Invalid Operation!");
        }

        this.capacity = capacity;
    }

    public String name() {
        return name;
    }

    public boolean add(Pet pet) throws Exception {
        if(pet == null) {
            throw new Exception("Invalid Operation!");
        }

        int middleRoom = capacity / 2 + 1;

        for (int i = 0; i < middleRoom; i++) {
            int leftIndexFromMid = middleRoom - i;
            int rightIndexFromMid = middleRoom + i;

            if (rooms.get(leftIndexFromMid) == null) {
                rooms.put(leftIndexFromMid, pet);

                return true;
            } else if (rooms.get(rightIndexFromMid) == null) {
                rooms.put(rightIndexFromMid, pet);

                return true;
            }
        }

        return false;
    }

    public boolean release() {
        int middleRoom = capacity / 2 + 1;

        for (int i = middleRoom; i <= capacity; i++) {
            if (rooms.get(i) != null) {
                rooms.put(i, null);

                return true;
            }
        }

        for (int i = 1; i <= middleRoom; i++) {
            if (rooms.get(i) != null) {
                rooms.put(i, null);

                return true;
            }
        }

        return false;
    }

    public boolean hasEmptyRooms() {
        return rooms.entrySet().stream().anyMatch(e -> e.getValue() == null);
    }

    public void printRoom(int room) {
        rooms.entrySet().stream()
                .filter(e -> e.getKey() == room)
                .forEach(e -> {
                    if(e.getValue() == null) {
                        System.out.println("Room empty");
                    } else {
                        System.out.println(e.getValue());
                    }
                });
    }

    public void printEachRoom() {
        rooms.forEach((key, value) -> {
            if (value == null) {
                System.out.println("Room empty");
            } else {
                System.out.println(value);
            }
        });
    }
}

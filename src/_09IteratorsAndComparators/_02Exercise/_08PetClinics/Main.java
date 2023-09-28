package _09IteratorsAndComparators._02Exercise._08PetClinics;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Clinic> clinics = new LinkedHashMap<>();
        Map<String, Pet> pets = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();

            if(command.startsWith("Create")) {
                String name = command.split(" ")[2];
                int age = Integer.parseInt(command.split(" ")[3]);

                if(command.split(" ")[1].equals("Pet")) {
                    String kind = command.split(" ")[4];
                    Pet pet = new Pet(name, age, kind);

                    pets.put(pet.name(), pet);
                } else {
                    try {
                        int rooms = age;
                        Clinic clinic = new Clinic(name, rooms);

                        clinics.put(clinic.name(), clinic);
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else if(command.startsWith("Add")) {
                String petName = command.split(" ")[1];
                String clinicName = command.split(" ")[2];

                try {
                    Pet pet = pets.get(petName);

                    System.out.println(clinics.get(clinicName).add(pet));
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if(command.startsWith("Release")) {
                String clinicName = command.split(" ")[1];

                Clinic clinic = clinics.get(clinicName);

                System.out.println(clinic.release());
            } else if(command.startsWith("HasEmptyRooms")) {
                String clinicName = command.split(" ")[1];

                System.out.println(clinics.get(clinicName).hasEmptyRooms());
            } else if(command.startsWith("Print")) {
                String clinicName = command.split(" ")[1];

                if (command.split(" ").length == 3) {
                    int room = Integer.parseInt(command.split(" ")[2]);

                    clinics.get(clinicName).printRoom(room);
                } else {

                    clinics.get(clinicName).printEachRoom();
                }
            }
        }

        System.out.println();
    }
}

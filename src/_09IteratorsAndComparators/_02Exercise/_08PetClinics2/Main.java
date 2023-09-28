package _09IteratorsAndComparators._02Exercise._08PetClinics2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Pet> pets = new ArrayList<>();
        List<Clinic> clinics = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();

            if(command.startsWith("Create Pet")) {
                String name = command.split(" ")[2];
                int age = Integer.parseInt(command.split(" ")[3]);
                String kind = command.split(" ")[4];

                pets.add(new Pet(name, age, kind));
            } else if(command.startsWith("Create Clinic")) {
                String name = command.split(" ")[2];
                int rooms = Integer.parseInt(command.split(" ")[3]);

                if(rooms % 2 == 0) {
                    System.out.println("Invalid Operation!");
                } else {
                    clinics.add(new Clinic(name, rooms));
                }
            } else if(command.startsWith("Add")) {
                String petName = command.split(" ")[1];
                String clinicName = command.split(" ")[2];

                boolean isClinicPresent = isClinicPresent(clinics, clinicName);
                boolean isPetPresent = pets.stream().anyMatch(e -> e.name().equals(petName));

                if(isClinicPresent && isPetPresent) {
                    Clinic clinic = getClinic(clinics, clinicName);

                    Pet pet = pets.stream().filter(e -> e.name().equals(petName)).findFirst().get();

                    System.out.println(clinic.add(pet));
                } else {
                    System.out.println(false);
                }
            } else if(command.startsWith("Release")) {
                String clinicName = command.split(" ")[1];

                boolean isClinicPresent = isClinicPresent(clinics, clinicName);

                if(isClinicPresent) {
                    Clinic clinic = getClinic(clinics, clinicName);

                    System.out.println(clinic.remove());
                } else {
                    System.out.println(false);
                }
            } else if(command.startsWith("HasEmptyRooms")) {

            } else if(command.startsWith("Print")) {
                int cmdPartsLength = command.split(" ").length;

                boolean printEachRoomInClinic = cmdPartsLength == 2;
                boolean printSpecifiedRoomInClinic = cmdPartsLength == 3;

                if(printSpecifiedRoomInClinic) {

                } else if(printEachRoomInClinic) {

                }
            }
        }
    }

    private static boolean isClinicPresent(List<Clinic> clinics, String clinicName) {
        return clinics.stream().anyMatch(e -> e.name().equals(clinicName));
    }

    private static Clinic getClinic(List<Clinic> clinics, String clinicName) {
        return clinics.stream().filter(e -> e.name().equals(clinicName)).findFirst().get();
    }
}

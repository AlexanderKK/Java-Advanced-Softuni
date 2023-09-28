package _06DefiningClasses._02Exercise._03SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Car> cars = new LinkedHashMap<>();

        //Enter cars
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");

            String model = data[0];
            int fuelAmount = Integer.parseInt(data[1]);
            double fuelCostPerKm = Double.parseDouble(data[2]);

            cars.put( model, new Car(model, fuelAmount, fuelCostPerKm) );
        }

        //Drive cars
        String command;
        while(!"End".equals(command = scanner.nextLine())) {
            String[] data = command.split(" ");

            String model = data[1];
            int kms = Integer.parseInt(data[2]);

            Car carToDrive = cars.get(model);
            carToDrive.drive(kms);
        }

        cars.values().forEach(System.out::println);
    }
}

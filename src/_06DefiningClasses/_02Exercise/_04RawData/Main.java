package _06DefiningClasses._02Exercise._04RawData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] data = input.split("\\s+");

            String model = data[0];

            //Instantiate Engine
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);

            Engine engine = new Engine(engineSpeed, enginePower);

            //Instantiate Cargo
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];

            Cargo cargo = new Cargo(cargoWeight, cargoType);

//            double tire1Pressure = Double.parseDouble(data[5]);
//            int tire1Age = Integer.parseInt(data[6]);
//
//            double tire2Pressure = Double.parseDouble(data[7]);
//            int tire2Age = Integer.parseInt(data[8]);
//
//            double tire3Pressure = Double.parseDouble(data[9]);
//            int tire3Age = Integer.parseInt(data[10]);
//
//            double tire4Pressure = Double.parseDouble(data[11]);
//            int tire4Age = Integer.parseInt(data[12]);

//            double[] tiresPressure = IntStream.range(0, data.length)
//                    .filter(index -> index > 4 && index % 2 != 0)
//                    .mapToDouble(e -> Double.parseDouble(data[e]))
//                    .toArray();
//
//            int[] tiresAge = IntStream.range(0, data.length)
//                    .filter(index -> index > 4 && index % 2 == 0)
//                    .map(e -> Integer.parseInt(data[e]))
//                    .toArray();

            List<Tire> tires = new ArrayList<>();

            int tirePressureIndex = 5;
            int tireAgeIndex = 6;

            for (int j = 1; j <= 4; j++) {
                double tirePressure = Double.parseDouble(data[tirePressureIndex]);
                int tireAge = Integer.parseInt(data[tireAgeIndex]);

                //Instantiate Tire
                Tire tire = new Tire(tirePressure, tireAge);
                tires.add(tire);

                tirePressureIndex += 2;
                tireAgeIndex += 2;
            }

            Car car = new Car(model, engine, cargo, tires);
            Garage.add(car);
        }

        String cargoType = scanner.nextLine();
        Garage.printByCargoType(cargoType);
    }
}

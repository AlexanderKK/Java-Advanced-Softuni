package _06DefiningClasses._02Exercise._05CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            saveData(scanner, engines, cars, "engine");
        }

        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            saveData(scanner, engines, cars, "car");
        }

        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static void saveData(Scanner scanner, List<Engine> engines, List<Car> cars, String object) {
        if(object.equals("engine")) {
            String[] data = scanner.nextLine().split(" ");

            String model = data[0];
            int power = Integer.parseInt(data[1]);

            Engine engine;

            if(data.length == 4) {
                int displacement  = Integer.parseInt(data[2]);
                String efficiency = data[3];

                engine = new Engine(model, power, displacement, efficiency);
            } else if(data.length == 3 && isInteger(data[2])) {
                int displacement  = Integer.parseInt(data[2]);

                engine = new Engine(model, power, displacement);
            } else if(data.length == 3 && !isInteger(data[2])) {
                String efficiency = data[2];

                engine = new Engine(model, power, efficiency);
            } else {
                engine = new Engine(model, power);
            }

            engines.add(engine);
        } else if(object.equals("car")) {
            String[] data = scanner.nextLine().split(" ");

            String carModel = data[0];
            String engineModel = data[1];
            Engine engine = engines.stream()
                    .filter(e -> e.model().equals(engineModel))
                    .collect(Collectors.toList()).get(0);

            Car car;

            if(data.length == 4) {
                int weight  = Integer.parseInt(data[2]);
                String color = data[3];

                car = new Car(carModel, engine, weight, color);
            } else if(data.length == 3 && isInteger(data[2])) {
                int weight  = Integer.parseInt(data[2]);

                car = new Car(carModel, engine, weight);
            } else if(data.length == 3 && !isInteger(data[2])) {
                String color = data[2];

                car = new Car(carModel, engine, color);
            } else {
                car = new Car(carModel, engine);
            }

            cars.add(car);
        }
    }

    private static boolean isInteger(String str) {
        for (char c : str.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}

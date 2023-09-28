package _06DefiningClasses._02Exercise._04RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Garage {
    private static List<Car> vehicles = new ArrayList<>();

    public static void add(Car car) {
        vehicles.add(car);
    }

    public static Consumer<Car> getModel(String condition) {
        if ("fragile".equals(condition)) {
            return car -> {
                List<Tire> tires = car.getTires();

                for (Tire tire : tires) {
                    if (tire.getTirePressure() < 1) {
                        System.out.println(car.getModel());
                        break;
                    }
                }
            };
        } else if ("flamable".equals(condition)) {
            return car -> {
                if (car.getEngine().getEnginePower() > 250) {
                    System.out.println(car.getModel());
                }
            };
        }
        throw new IllegalArgumentException("Unknown condition" + condition);
    }

    public static void printByCargoType(String cargoType) {
        for (Car car : vehicles) {
            if (car.getCargo().getCargoType().equals(cargoType) && cargoType.equals("fragile")) {
                getModel(cargoType).accept(car);
            } else if (car.getCargo().getCargoType().equals(cargoType) && cargoType.equals("flamable")) {
                getModel(cargoType).accept(car);
            }
        }
    }
}

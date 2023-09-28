package _09IteratorsAndComparators._01Lab._00Demo;

import java.lang.reflect.Array;
import java.util.List;

public class Main {
    public static class Car {
        int year;
        int fuel;
    }

    public static void main(String[] args) {

        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

//        List<Car> cars = List.of(car1, car2, car3);

        addFuel(13, car1, car2, car3);

        System.out.println(car1.fuel);
    }

    /**
     * Variable arguments
     * @param cars
     */
    public static void addFuel(Object... cars) {
        Car[] carsArr = (Car[]) cars;

        for (Car car : (Car[]) cars) {
            car.fuel += 10;
        }
    }
}

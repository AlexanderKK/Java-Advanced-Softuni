package _10ExamPreparation._02.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private final String type;
    private final List<Car> data;
    private final int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>(capacity);
    }

    public void add(Car newCar) {
        boolean isPresent = data.stream().anyMatch(e -> e.compareTo(newCar) == 0);

        if(!isPresent) {
            data.add(newCar);
        }
    }

    public boolean remove(String manufacturer, String model) {
        boolean isCarPresent = data.stream().anyMatch(e -> e.manufacturer().equals(manufacturer) && e.model().equals(model));

        if(isCarPresent) {
            Car carToRemove = data.stream().filter(e -> e.manufacturer().equals(manufacturer) && e.model().equals(model)).findAny().get();

            data.remove(carToRemove);

            return true;
        }
        return false;
    }

    public int getCount() {
        return data.size();
    }

    public Car getLatestCar() {
        if(getCount() > 0) {
            return data.stream().sorted((f, s) -> s.year() - f.year()).findFirst().get();
        }
        return null;
    }

    public Car getCar(String manufacturer, String model) {
        boolean isCarPresent = data.stream().anyMatch(e -> e.manufacturer().equals(manufacturer) && e.model().equals(model));

        if(isCarPresent) {
            Car car = data.stream().filter(e -> e.manufacturer().equals(manufacturer) && e.model().equals(model)).findAny().get();

            return car;
        }

        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder(
                String.format("The cars are parked in %s:", type))
                .append(System.lineSeparator());

        data.forEach(e -> sb.append(e).append(System.lineSeparator()));

        return sb.toString();
    }
}

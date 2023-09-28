package _10ExamPreparation._02.parking;

public class Car implements Comparable<Car> {
    private String manufacturer;
    private String model;
    private int year;

    public Car(String manufacturer, String model, int year) {
        setManufacturer(manufacturer);
        setModel(model);
        setYear(year);
    }

    public String manufacturer() {
        return manufacturer;
    }

    public String model() {
        return model;
    }

    public int year() {
        return year;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d)", manufacturer, model, year);
    }

    @Override
    public int compareTo(Car other) {
        int resultManufacturer = this.manufacturer.compareTo(other.manufacturer);
        int resultModel = this.model.compareTo(other.model);

        int result = -1;

        if(resultManufacturer == 0 && resultModel == 0) {
            result = 0;
        }

        if(this.year == other.year) {
            result = 0;
        }

        return result;
    }
}

package _06DefiningClasses._01Lab._02CarConstructors;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public Car(String brand) {
        this(brand, "unknown", -1);
    }

    public void carInfo() {
        System.out.printf("The car is: %s %s - %d HP.%n", brand, model, horsePower);
    }
}

package _06DefiningClasses._01Lab._01CarInfo;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void carInfo() {
        System.out.printf("The car is: %s %s - %d HP.%n", brand, model, horsePower);
    }
}

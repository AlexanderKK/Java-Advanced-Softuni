package _06DefiningClasses._02Exercise._03SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int distanceTraveled;

    public Car(String model, int fuelAmount, double fuelCostPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
    }

    public void drive(int kms) {
        double fuelNeeded = kms * fuelCostPerKm;

        if(fuelNeeded > fuelAmount) {
            System.out.println("Insufficient fuel for the drive");
        } else {
            fuelAmount -= fuelNeeded;
            distanceTraveled += kms;
        }
    }

    public String model() {
        return model;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, distanceTraveled);
    }
}

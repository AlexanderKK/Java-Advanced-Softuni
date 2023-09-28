package _06DefiningClasses._02Exercise._05CarSalesman;

public class Engine {
    private String model;
    private int power;
    private Object displacement;
    private String efficiency;

    public Engine(String model, int power, Object displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, "n/a", efficiency);
    }

    public Engine(String model, int power) {
        this(model, power, "n/a", "n/a");
    }

    public String model() {
        return model;
    }

    public int power() {
        return power;
    }

    public Object displacement() {
        return displacement;
    }

    public String efficiency() {
        return efficiency;
    }
}

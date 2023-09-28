package _06DefiningClasses._02Exercise._05CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private Object weight;
    private String color;

    public Car(String model, Engine engine, Object weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, "n/a", color);
    }

    public Car(String model, Engine engine) {
        this(model, engine, "n/a");
    }

    //{CarModel}:
    //{EngineModel}:
    //Power: {EnginePower}
    //Displacement: {EngineDisplacement}
    //Efficiency: {EngineEfficiency}
    //Weight: {CarWeight}
    //Color: {CarColor}

    @Override
    public String toString() {
        return String.format("%s:%n%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s",
                model, engine.model(), engine.power(), engine.displacement(), engine.efficiency(), weight, color);
    }
}

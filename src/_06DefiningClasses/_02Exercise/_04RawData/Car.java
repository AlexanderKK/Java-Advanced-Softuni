package _06DefiningClasses._02Exercise._04RawData;

import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Engine getEngine() {
        return engine;
    }

    public List<Tire> getTires() {
        return tires;
    }

    @Override
    public String toString() {
        return model;

//        StringBuilder result = new StringBuilder(
//                String.format("%s %d %d %d %s ",
//                model, engine.getEngineSpeed(), engine.getEnginePower(),
//                cargo.getCargoWeight(), cargo.getCargoType())
//        );
//
//        tires.forEach(tire -> {
//            result.append(tire.getTirePressure() + " " + tire.getTireAge() + " ");
//        });
//
//        return result.toString();
    }
}

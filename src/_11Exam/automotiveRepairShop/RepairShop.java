package _11Exam.automotiveRepairShop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepairShop {
    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public int getCount() {
        return vehicles.size();
    }

    public void addVehicle(Vehicle vehicle) {
        boolean isVehiclePresent = vehicles.stream()
                .anyMatch(v -> v.getVIN().equals(vehicle.getVIN()));

        if(getCount() < capacity && !isVehiclePresent) {
            vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin) {
        return vehicles.removeIf(v -> v.getVIN().equals(vin));

//        Vehicle vehicle = vehicles.stream().filter(v -> v.getVIN().equals(vin)).findFirst().orElse(null);
//        if(vehicle != null) {
//            vehicles.remove(vehicle);
//            return true;
//        }
//        return false;
    }

    public Vehicle getLowestMileage() {
        return vehicles.stream().min(Comparator.comparingInt(Vehicle::getMileage)).orElse(null);

//        Vehicle vehicleMinMileage = vehicles.get(0);
//
//        for (Vehicle vehicle : vehicles) {
//            if (vehicle.getMileage() < vehicleMinMileage.getMileage()) {
//                vehicleMinMileage = vehicle;
//            }
//        }
//
//        return vehicleMinMileage;
    }

    public String report() {
        StringBuilder sbReport = new StringBuilder();
        sbReport.append("Vehicles in the preparatory:").append(System.lineSeparator());

        vehicles.forEach(v -> sbReport.append(v).append(System.lineSeparator()));

        return sbReport.toString();
    }
}

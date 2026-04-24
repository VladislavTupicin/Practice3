package part3.part3_1.model;

public class Truck extends Vehicle {
    private double cargoCapacityTons;

    public Truck(String brand, String model, int year, double cargoCapacityTons) {
        super(brand, model, year);
        this.cargoCapacityTons = cargoCapacityTons;
    }

    @Override
    public double getFuelConsumption() {
        return 20 + cargoCapacityTons * 3;
    }

    @Override
    public String getType() {
        return "Грузовой автомобиль";
    }
}
package part3.part3_1.model;

public abstract class Vehicle {
    private String brand;
    private String model;
    private int year;
    private double fuelLevel;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelLevel = 1.0;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getFuelLevel() { return fuelLevel; }

    public void setFuelLevel(double fuelLevel) {
        if (fuelLevel >= 0.0 && fuelLevel <= 1.0) {
            this.fuelLevel = fuelLevel;
        }
    }

    public abstract double getFuelConsumption();
    public abstract String getType();

    public double calculateFuelNeeded(double distanceKm) {
        return (getFuelConsumption() * distanceKm) / 100;
    }

    public boolean canTravel(double distanceKm, double tankCapacityLitres) {
        return (tankCapacityLitres * fuelLevel) >= calculateFuelNeeded(distanceKm);
    }

    @Override
    public String toString() {
        return brand + " " + model + " (" + year + ")";
    }
}
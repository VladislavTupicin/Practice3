package part3.part3_1.model;

import part3.part3_1.interfaces.Electric;

public class ElectricCar extends Car implements Electric {
    private double batteryLevel;
    private double maxRangeKm;

    public ElectricCar(String brand, String model, int year, int doors,
                       boolean automatic, double maxRangeKm) {
        super(brand, model, year, doors, automatic);
        this.batteryLevel = 0.8;
        this.maxRangeKm = maxRangeKm;
    }

    @Override
    public double getFuelConsumption() {
        return 0;
    }

    @Override
    public String getType() {
        return "Электромобиль";
    }

    @Override
    public double getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public double getRangeKm() {
        return maxRangeKm * batteryLevel;
    }

    @Override
    public void charge(double hours) {
        batteryLevel = Math.min(1.0, batteryLevel + hours * 0.2);
    }
}
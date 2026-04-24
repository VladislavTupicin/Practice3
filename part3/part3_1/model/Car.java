package part3.part3_1.model;

public class Car extends Vehicle {
    private int doors;
    private boolean automatic;

    public Car(String brand, String model, int year, int doors, boolean automatic) {
        super(brand, model, year);
        this.doors = doors;
        this.automatic = automatic;
    }

    @Override
    public double getFuelConsumption() {
        return automatic ? 9.5 : 8.0;
    }

    @Override
    public String getType() {
        return "Легковой автомобиль";
    }

    public void honk() {
        System.out.println(getBrand() + " " + getModel() + ": Бип-бип!");
    }
}
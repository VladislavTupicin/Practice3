package part3.part3_1.demo;

import part3.part3_1.model.*;
import part3.part3_1.interfaces.Electric;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Group: ИТ-31");
        System.out.println("Date: " + LocalDate.now());
        System.out.println();

        List<Vehicle> vehicles = new ArrayList<>();

        Car toyota = new Car("Toyota", "Camry", 2022, 4, true);
        Car lada = new Car("Lada", "Vesta", 2023, 4, false);
        Truck kamaz = new Truck("Kamaz", "5490", 2021, 15.0);
        ElectricCar tesla = new ElectricCar("Tesla", "Model 3", 2024, 4, true, 600);

        vehicles.add(toyota);
        vehicles.add(lada);
        vehicles.add(kamaz);
        vehicles.add(tesla);

        System.out.println("=== Информация о транспортных средствах ===\n");

        for (Vehicle v : vehicles) {
            System.out.println("Тип: " + v.getType());
            System.out.println("Модель: " + v.getBrand() + " " + v.getModel());
            System.out.println("Расход: " + v.getFuelConsumption() + " л/100км");
            System.out.printf("На 500 км нужно: %.2f л%n", v.calculateFuelNeeded(500));

            if (v instanceof ElectricCar) {
                ElectricCar ev = (ElectricCar) v;
                System.out.printf("Запас хода: %.0f км%n", ev.getRangeKm());
            }
            System.out.println("------------------------");
        }

        System.out.println("\n=== Полиморфизм ===\n");

        for (Vehicle v : vehicles) {
            if (v instanceof Car) {
                ((Car) v).honk();
            }
            if (v instanceof Electric) {
                System.out.println("Запас хода: " + ((Electric) v).getRangeKm() + " км");
            }
        }
    }
}
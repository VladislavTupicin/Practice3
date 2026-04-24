package part5.part5_1;

public abstract class Predator extends Animal {

    public Predator(String name, int age, double weight) {
        super(name, age, weight);
    }

    public void hunt() {
        if (energyLevel < 20) {
            System.out.println(name + " слишком устал для охоты!");
            return;
        }
        energyLevel += 30;
        weight -= 0.5;
        if (energyLevel > 100) energyLevel = 100;
        if (weight < 0) weight = 0;
        System.out.println(name + " охотится! Энергия: " + String.format("%.1f", energyLevel));
    }
}
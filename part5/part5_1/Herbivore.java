package part5.part5_1;

public abstract class Herbivore extends Animal {

    public Herbivore(String name, int age, double weight) {
        super(name, age, weight);
    }

    public void graze() {
        energyLevel += 15;
        weight += 0.3;
        if (energyLevel > 100) energyLevel = 100;
        System.out.println(name + " пасётся. Энергия: " + String.format("%.1f", energyLevel));
    }
}
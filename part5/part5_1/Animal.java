package part5.part5_1;

public abstract class Animal {
    protected String name;
    protected int age;
    protected double weight;
    protected double energyLevel; // 0-100

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.energyLevel = 50; // средний уровень энергии
    }

    public void eat(int calories) {
        energyLevel += calories * 0.2;
        weight += calories * 0.01;
        if (energyLevel > 100) energyLevel = 100;
        System.out.println(name + " поел. Энергия: " + String.format("%.1f", energyLevel));
    }

    public void sleep(int hours) {
        energyLevel += hours * 5;
        if (energyLevel > 100) energyLevel = 100;
        System.out.println(name + " поспал " + hours + "ч. Энергия: " + String.format("%.1f", energyLevel));
    }

    public abstract void makeSound();

    public String getName() { return name; }
    public double getEnergyLevel() { return energyLevel; }
    public double getWeight() { return weight; }
    public int getAge() { return age; }

    public void setEnergyLevel(double energyLevel) {
        this.energyLevel = Math.min(100, Math.max(0, energyLevel));
    }

    public boolean isHungry() {
        return energyLevel < 30;
    }

    @Override
    public String toString() {
        return String.format("%s (%d лет, %.1f кг) - Энергия: %.0f",
                name, age, weight, energyLevel);
    }
}
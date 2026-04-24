package part5.part5_1;

import java.util.*;
import java.util.stream.Collectors;

public class Zoo {
    private List<Animal> animals = new ArrayList<>();
    private Map<String, List<String>> trainedAnimals = new HashMap<>();

    public void addAnimal(Animal a) {
        animals.add(a);
        System.out.println("В зоопарк добавлен: " + a.getName());
    }

    public void feedAll() {
        System.out.println("\n=== Кормление всех животных ===");
        for (Animal a : animals) {
            a.eat(100);
        }
    }

    public void makeNoise() {
        System.out.println("\n=== Все животные издают звуки ===");
        for (Animal a : animals) {
            a.makeSound();
        }
    }

    public List<Animal> getHungryAnimals() {
        return animals.stream()
                .filter(a -> a.getEnergyLevel() < 30)
                .collect(Collectors.toList());
    }

    public Optional<Animal> findAnimal(String name) {
        return animals.stream()
                .filter(a -> a.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public void trainAnimal(String name, String command) {
        findAnimal(name).ifPresentOrElse(
                animal -> {
                    if (animal instanceof Trainable) {
                        Trainable t = (Trainable) animal;
                        boolean success = t.train(command);
                        if (success) {
                            trainedAnimals.computeIfAbsent(name, k -> new ArrayList<>()).add(command);
                            System.out.println(name + " выучил команду: " + command);
                        } else {
                            System.out.println(name + " не смог выучить команду: " + command);
                        }
                    } else {
                        System.out.println(name + " не умеет обучаться!");
                    }
                },
                () -> System.out.println("Животное " + name + " не найдено")
        );
    }

    public void listAllAnimals() {
        System.out.println("\n=== Все животные в зоопарке ===");
        for (Animal a : animals) {
            System.out.println("  " + a);
        }
    }

    public void printHungryAnimals() {
        List<Animal> hungry = getHungryAnimals();
        if (hungry.isEmpty()) {
            System.out.println("Нет голодных животных!");
        } else {
            System.out.println("\n=== Голодные животные (энергия < 30) ===");
            for (Animal a : hungry) {
                System.out.println("  " + a.getName() + " - энергия: " + a.getEnergyLevel());
            }
        }
    }
}
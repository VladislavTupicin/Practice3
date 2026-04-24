package part5.part5_1;

import java.time.LocalDate;

public class ZooDemo {
    public static void main(String[] args) {
        System.out.println("Group: ИТ-31");
        System.out.println("Sequence number: 1");
        System.out.println("Date: " + LocalDate.now());
        System.out.println("=".repeat(50));
        System.out.println();

        Zoo zoo = new Zoo();

        // Добавление животных
        System.out.println("=== Добавление животных ===");
        Lion simba = new Lion("Симба", 5, 180);
        Lion nala = new Lion("Нала", 4, 160);
        Elephant dumbo = new Elephant("Дамбо", 10, 3500);
        Elephant horton = new Elephant("Хортон", 8, 3200);

        zoo.addAnimal(simba);
        zoo.addAnimal(nala);
        zoo.addAnimal(dumbo);
        zoo.addAnimal(horton);

        zoo.listAllAnimals();

        // Животные издают звуки
        zoo.makeNoise();

        // Специфические действия
        System.out.println("\n=== Специфические действия ===");
        simba.roar();
        simba.hunt();
        dumbo.trumpet();
        dumbo.graze();

        // Проверка голодных животных
        zoo.printHungryAnimals();

        // Кормление
        zoo.feedAll();

        zoo.printHungryAnimals();

        // Поиск животного
        System.out.println("\n=== Поиск животного ===");
        zoo.findAnimal("Симба").ifPresentOrElse(
                a -> System.out.println("Найден: " + a),
                () -> System.out.println("Животное не найдено")
        );

        zoo.findAnimal("Годзилла").ifPresentOrElse(
                a -> System.out.println("Найден: " + a),
                () -> System.out.println("Животное не найдено")
        );

        // Демонстрация работы с Trainable (добавим обучаемое животное)
        System.out.println("\n=== Дрессировка ===");
        // Создадим класс Dog (можно добавить позже)
        System.out.println("Примечание: Животные в текущей реализации не реализуют Trainable.");
        System.out.println("Для демонстрации интерфейса можно добавить класс Dog.");

        // Финальный отчёт
        System.out.println("\n=== Итоговое состояние зоопарка ===");
        zoo.listAllAnimals();
    }
}
package part2;

import java.time.LocalDate;

public class MultiplicationTable {

    public static void printTable() {
        System.out.println("Таблица умножения 1x1 до 10x10:");
        System.out.println();

        // Верхняя строка с множителями
        System.out.print("     ");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();
        System.out.print("     ");
        for (int i = 1; i <= 10; i++) {
            System.out.print("----");
        }
        System.out.println();

        // Основная таблица
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%2d |", i);
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Group: ИТ-31");
        System.out.println("Sequence number: 1");
        System.out.println("Date: " + LocalDate.now());
        System.out.println();

        printTable();
    }
}
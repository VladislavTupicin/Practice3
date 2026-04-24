package part1.part1_1;

import java.time.LocalDate;

public class NumberClassifier {

    public static String classify(int number) {
        if (number < 0) return "отрицательное";
        if (number == 0) return "ноль";
        if (number < 10) return "однозначное";
        if (number < 100) return "двузначное";
        if (number < 1000) return "трёхзначное";
        return "большое (четырехзначное и более)";
    }

    public static void main(String[] args) {
        // Информация о студенте
        System.out.println("Group: ИТ-31");          // замени на свою группу
        System.out.println("Sequence number: 1");     // замени на свой номер
        System.out.println("Date: " + LocalDate.now());

        // Тестирование
        int[] samples = {-5, 0, 7, 42, 100, 1000, -999};
        for (int n : samples) {
            System.out.println(n + " -> " + classify(n));
        }
    }
}
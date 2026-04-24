package part1.part1_2;

import java.time.LocalDate;

public class GradeChecker {

    /**
     * Конвертирует баллы в оценку по шкале:
     * 0-19 -> "Неудовлетворительно (2)"
     * 20-39 -> "Удовлетворительно (3)"
     * 40-69 -> "Хорошо (4)"
     * 70-100 -> "Отлично (5)"
     */
    public static String convertToGrade(int score) {
        if (score < 0 || score > 100) {
            return "Некорректный балл";
        } else if (score < 20) {
            return "Неудовлетворительно (2)";
        } else if (score < 40) {
            return "Удовлетворительно (3)";
        } else if (score < 70) {
            return "Хорошо (4)";
        } else {
            return "Отлично (5)";
        }
    }

    /**
     * Проверка: сдал экзамен или нет (балл >= 20)
     */
    public static String isPassed(int score) {
        if (score >= 20 && score <= 100) {
            return "Сдан";
        } else if (score >= 0 && score < 20) {
            return "Не сдан";
        } else {
            return "Некорректный балл";
        }
    }

    public static void main(String[] args) {
        System.out.println("Group: ИТ-31");
        System.out.println("Sequence number: 1");
        System.out.println("Date: " + LocalDate.now());
        System.out.println();

        System.out.println("=== Таблица соответствия баллов и оценок ===");
        System.out.println("Баллы\tОценка\t\tРезультат");
        System.out.println("----------------------------------------");

        int[] scores = {-5, 0, 15, 20, 35, 40, 65, 70, 85, 100, 105};

        for (int score : scores) {
            System.out.println(score + "\t" + convertToGrade(score) + "\t\t" + isPassed(score));
        }
    }
}
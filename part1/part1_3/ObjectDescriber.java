package part1.part1_3;

import java.time.LocalDate;

public class ObjectDescriber {

    /**
     * Анализирует число: знак и чётность
     */
    public static String describeNumber(int number) {
        if (number == 0) {
            return "ноль";
        }

        String sign = (number > 0) ? "положительное" : "отрицательное";
        String parity = (number % 2 == 0) ? "чётное" : "нечётное";

        return sign + " " + parity;
    }

    /**
     * Анализирует строку: длина, наличие цифр, регистр
     */
    public static String describeString(String text) {
        if (text == null || text.isEmpty()) {
            return "пустая строка";
        }

        int length = text.length();
        boolean hasDigits = text.matches(".*\\d.*");

        String result = "длина: " + length;

        if (hasDigits) {
            result += ", содержит цифры";
        }

        if (text.equals(text.toUpperCase()) && !text.equals(text.toLowerCase())) {
            result += ", ВЕРХНИЙ РЕГИСТР";
        } else if (text.equals(text.toLowerCase()) && !text.equals(text.toUpperCase())) {
            result += ", нижний регистр";
        } else if (text.matches(".*[A-Za-zА-Яа-я].*")) {
            result += ", смешанный регистр";
        }

        return result;
    }

    /**
     * Определяет тип объекта
     */
    public static String getObjectType(Object obj) {
        if (obj == null) {
            return "null";
        }

        String type = obj.getClass().getSimpleName();

        if (type.equals("String")) return "Строка";
        if (type.equals("Integer")) return "Целое число";
        if (type.equals("Double")) return "Дробное число";
        if (type.equals("Boolean")) return "Логический тип";

        return "Объект: " + type;
    }

    public static void main(String[] args) {
        System.out.println("Group: ИТ-31");
        System.out.println("Sequence number: 1");
        System.out.println("Date: " + LocalDate.now());
        System.out.println();

        // Тестирование describeNumber
        System.out.println("=== describeNumber ===");
        int[] numbers = {-5, -2, 0, 1, 4, 7};
        for (int num : numbers) {
            System.out.println(num + " -> " + describeNumber(num));
        }

        // Тестирование describeString
        System.out.println("\n=== describeString ===");
        String[] strings = {"", "hello", "HELLO", "HeLLo", "java123", "Hello World"};
        for (String str : strings) {
            System.out.println("\"" + str + "\" -> " + describeString(str));
        }

        // Тестирование getObjectType
        System.out.println("\n=== getObjectType ===");
        System.out.println("Hello -> " + getObjectType("Hello"));
        System.out.println("42 -> " + getObjectType(42));
        System.out.println("3.14 -> " + getObjectType(3.14));
        System.out.println("true -> " + getObjectType(true));
        System.out.println("null -> " + getObjectType(null));
    }
}
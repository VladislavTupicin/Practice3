package part2;

import java.time.LocalDate;

public class StringProcessor {

    // Подсчёт гласных (русские + английские)
    public static int countVowels(String text) {
        if (text == null || text.isEmpty()) return 0;

        String vowels = "аеёиоуыэюяaeiouy";
        int count = 0;
        String lowerText = text.toLowerCase();

        for (int i = 0; i < lowerText.length(); i++) {
            char c = lowerText.charAt(i);
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    // Проверка на палиндром (без учёта регистра и знаков препинания)
    public static boolean isPalindrome(String text) {
        if (text == null || text.isEmpty()) return true;

        // Очищаем: оставляем только буквы и цифры
        String cleaned = text.toLowerCase().replaceAll("[^a-zа-яё0-9]", "");

        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Реверс строки (без StringBuilder)
    public static String reverse(String text) {
        if (text == null || text.isEmpty()) return text;

        char[] chars = text.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    // Самое длинное слово в предложении
    public static String findLongestWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) return "";

        String[] words = sentence.split("[\\s,;:.!?]+");
        String longest = "";

        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println("Group: ИТ-31");
        System.out.println("Sequence number: 1");
        System.out.println("Date: " + LocalDate.now());
        System.out.println();

        // Тестирование
        String[] testStrings = {
                "Привет, Java-разработчик!",
                "топот",
                "Madam",
                "hello",
                "А роза упала на лапу Азора",
                "The quick brown fox jumps over the lazy dog"
        };

        System.out.println("=== Подсчёт гласных ===");
        for (String s : testStrings) {
            System.out.println("\"" + s + "\" -> гласных: " + countVowels(s));
        }

        System.out.println("\n=== Проверка на палиндром ===");
        for (String s : testStrings) {
            System.out.println("\"" + s + "\" -> " + (isPalindrome(s) ? "палиндром" : "не палиндром"));
        }

        System.out.println("\n=== Реверс строки ===");
        for (String s : testStrings) {
            System.out.println("\"" + s + "\" -> \"" + reverse(s) + "\"");
        }

        System.out.println("\n=== Самое длинное слово ===");
        for (String s : testStrings) {
            System.out.println("\"" + s + "\" -> \"" + findLongestWord(s) + "\"");
        }
    }
}
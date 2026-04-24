package part4.part4_1;

import java.time.LocalDate;

public class DiscountCalculator {

    // 1. Перегрузка по типу клиента
    public static double calculateDiscount(double price, String customerType) {
        return switch (customerType.toLowerCase()) {
            case "vip" -> price * 0.30;
            case "regular" -> price * 0.10;
            case "new" -> price * 0.05;
            default -> 0;
        };
    }

    // 2. Перегрузка по количеству покупок
    public static double calculateDiscount(double price, int purchaseCount) {
        if (purchaseCount >= 100) return price * 0.20;
        if (purchaseCount >= 50) return price * 0.15;
        if (purchaseCount >= 10) return price * 0.10;
        return 0;
    }

    // 3. Перегрузка по промокоду (и флагу первого заказа)
    public static double calculateDiscount(double price, String promoCode, boolean isFirstOrder) {
        double discount = 0;
        if ("SAVE10".equals(promoCode)) discount = price * 0.10;
        if ("SAVE20".equals(promoCode)) discount = price * 0.20;
        if (isFirstOrder) discount += price * 0.05;
        return Math.min(discount, price * 0.50); // Не более 50%
    }

    // 4. Дополнительная перегрузка: по возрасту клиента
    public static double calculateDiscount(double price, int age, boolean isStudent) {
        double discount = 0;

        if (age >= 60) {
            discount = price * 0.20; // пенсионерам 20%
        } else if (age <= 18) {
            discount = price * 0.15; // детям 15%
        } else if (isStudent) {
            discount = price * 0.10; // студентам 10%
        }

        return Math.min(discount, price * 0.30);
    }

    public static void main(String[] args) {
        System.out.println("Group: ИТ-31");
        System.out.println("Sequence number: 1");
        System.out.println("Date: " + LocalDate.now());
        System.out.println("=".repeat(50));
        System.out.println();

        double price = 10000.0;

        System.out.println("=== Перегрузка по типу клиента ===");
        System.out.println("Цена: " + price + " руб.");
        System.out.println("VIP клиент: " + calculateDiscount(price, "vip") + " руб.");
        System.out.println("Regular клиент: " + calculateDiscount(price, "regular") + " руб.");
        System.out.println("Новый клиент: " + calculateDiscount(price, "new") + " руб.");

        System.out.println("\n=== Перегрузка по количеству покупок ===");
        System.out.println("75 покупок: " + calculateDiscount(price, 75) + " руб.");
        System.out.println("100 покупок: " + calculateDiscount(price, 100) + " руб.");
        System.out.println("5 покупок: " + calculateDiscount(price, 5) + " руб.");

        System.out.println("\n=== Перегрузка по промокоду ===");
        System.out.println("SAVE10: " + calculateDiscount(price, "SAVE10", false) + " руб.");
        System.out.println("SAVE20: " + calculateDiscount(price, "SAVE20", false) + " руб.");
        System.out.println("SAVE20 + первый заказ: " + calculateDiscount(price, "SAVE20", true) + " руб.");

        System.out.println("\n=== Дополнительная перегрузка (по возрасту) ===");
        System.out.println("Пенсионер (65 лет): " + calculateDiscount(price, 65, false) + " руб.");
        System.out.println("Школьник (15 лет): " + calculateDiscount(price, 15, false) + " руб.");
        System.out.println("Студент (20 лет, студент): " + calculateDiscount(price, 20, true) + " руб.");
        System.out.println("Обычный (30 лет): " + calculateDiscount(price, 30, false) + " руб.");
    }
}
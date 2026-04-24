package part2;

import java.time.LocalDate;

public class Fibonacci {

    // Итеративный метод с while
    public static long fibIterative(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        long a = 0, b = 1;
        int i = 2;
        while (i <= n) {
            long next = a + b;
            a = b;
            b = next;
            i++;
        }
        return b;
    }

    // Метод с for
    public static long fibFor(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long next = a + b;
            a = b;
            b = next;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println("Group: ИТ-31");
        System.out.println("Sequence number: 1");
        System.out.println("Date: " + LocalDate.now());
        System.out.println();

        // Вывод F(0) до F(15)
        System.out.println("Числа Фибоначчи (через итеративный метод):");
        for (int i = 0; i <= 15; i++) {
            System.out.printf("F(%2d) = %d%n", i, fibIterative(i));
        }

        System.out.println("\nЧисла Фибоначчи (через for-метод):");
        for (int i = 0; i <= 15; i++) {
            System.out.printf("F(%2d) = %d%n", i, fibFor(i));
        }

        // Поиск первого числа Фибоначчи > 1000
        int n = 0;
        while (fibIterative(n) <= 1000) {
            n++;
        }
        System.out.println("\nПервое число Фибоначчи, превышающее 1000:");
        System.out.println("F(" + n + ") = " + fibIterative(n));
    }
}
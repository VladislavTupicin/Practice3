package part2;

import java.time.LocalDate;

public class LoopControl {
    public static void main(String[] args) {
        System.out.println("Group: ИТ-31");
        System.out.println("Sequence number: 1");
        System.out.println("Date: " + LocalDate.now());
        System.out.println();
        System.out.println("=== Пояснения к работе меток ===");
        System.out.println("1. Метка 'outer' помечает внешний while-цикл.");
        System.out.println("   Метка 'search' могла бы быть использована для вложенных циклов.");
        System.out.println("2. 'continue outer' прерывает текущую итерацию внутреннего цикла");
        System.out.println("   и переходит к следующей итерации помеченного внешнего цикла.");
        System.out.println("3. Это позволяет эффективно искать простое число, пропуская составные.\n");

        // Блок 1: Найти первое простое число больше 100
        System.out.println("--- Блок 1: Первое простое число > 100 ---");
        int n = 101;
        outer:
        while (true) {
            if (n % 2 == 0 && n != 2) {
                n++;
                continue;
            }
            for (int d = 3; d * d <= n; d += 2) {
                if (n % d == 0) {
                    n++;
                    continue outer;
                }
            }
            break;
        }
        System.out.println("Первое простое > 100: " + n);

        // Блок 2: Нечётные, не кратные 3
        System.out.println("\n--- Блок 2: Нечётные, не кратные 3 (1-20) ---");
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) continue;
            if (i % 3 == 0) continue;
            System.out.print(i + " ");
        }
        System.out.println();

        // Блок 3: Поиск в матрице
        System.out.println("\n--- Блок 3: Поиск в матрице ---");
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int target = 5;
        boolean found = false;
        search:
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    System.out.println("Найдено " + target + " на позиции [" + i + "][" + j + "]");
                    found = true;
                    break search;
                }
            }
        }
        if (!found) {
            System.out.println(target + " не найдено");
        }

        // Пояснения
        System.out.println("\n=== ПОЯСНЕНИЯ ===");
        System.out.println("(1) Метка 'outer' используется для выхода из вложенных циклов.");
        System.out.println("    'continue outer' переходит на следующую итерацию внешнего цикла.");
        System.out.println("(2) В блоке 1 'continue outer' при обнаружении делителя увеличивает n");
        System.out.println("    и переходит к проверке следующего числа, пропуская оставшийся код.");
        System.out.println("(3) Результаты:");
        System.out.println("    Блок 1: 101 (первое простое после 100)");
        System.out.println("    Блок 2: 1 5 7 11 13 17 19 (нечётные, не кратные 3)");
        System.out.println("    Блок 3: 'Найдено 5 на позиции [1][1]'");
    }
}
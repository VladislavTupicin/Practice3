package part3.part3_2;

import java.time.LocalDate;

public class BankAccountDemo {
    public static void main(String[] args) {
        System.out.println("Group: ИТ-31");
        System.out.println("Sequence number: 1");
        System.out.println("Date: " + LocalDate.now());
        System.out.println("=".repeat(50));
        System.out.println();

        // Создание счёта
        BankAccount account = new BankAccount("40817810123456789012",
                "Иван Петров", "1234", 150_000);

        System.out.println("=== 1. Начальное состояние ===");
        System.out.println(account);
        System.out.println();

        // Пополнение
        System.out.println("=== 2. Пополнение счёта ===");
        account.deposit(25_000);
        System.out.println(account);
        System.out.println();

        // Корректное снятие
        System.out.println("=== 3. Снятие средств (верный PIN) ===");
        account.withdraw("1234", 30_000);
        System.out.println(account);
        System.out.println();

        // Неверный PIN - попытка 1
        System.out.println("=== 4. Неверный PIN (попытка 1/3) ===");
        account.withdraw("1111", 10_000);
        System.out.println(account);
        System.out.println();

        // Неверный PIN - попытка 2
        System.out.println("=== 5. Неверный PIN (попытка 2/3) ===");
        account.withdraw("2222", 10_000);
        System.out.println(account);
        System.out.println();

        // Неверный PIN - попытка 3 (блокировка)
        System.out.println("=== 6. Неверный PIN (попытка 3/3 - блокировка) ===");
        account.withdraw("3333", 10_000);
        System.out.println(account);
        System.out.println();

        // Попытка операции после блокировки
        System.out.println("=== 7. Попытка операции после блокировки ===");
        account.withdraw("1234", 10_000);
        System.out.println();

        // Создание второго счёта для демонстрации маскировки баланса
        System.out.println("=== 8. Демонстрация маскировки баланса ===");
        BankAccount smallAccount = new BankAccount("40817810222222222222",
                "Пётр Сидоров", "5678", 50_000);
        BankAccount bigAccount = new BankAccount("40817810333333333333",
                "Анна Иванова", "9012", 250_000);

        System.out.println("Маленький баланс: " + smallAccount.getMaskedBalance());
        System.out.println("Большой баланс: " + bigAccount.getMaskedBalance());
        System.out.println();

        // Изменение PIN-кода (создаём новый незаблокированный счёт)
        System.out.println("=== 9. Изменение PIN-кода ===");
        BankAccount newAccount = new BankAccount("40817810444444444444",
                "Дмитрий Соколов", "0000", 10_000);
        System.out.println("До изменения: PIN = 0000");
        newAccount.changePin("0000", "9999");
        System.out.println("Проверка нового PIN:");
        newAccount.withdraw("9999", 1_000);
    }
}
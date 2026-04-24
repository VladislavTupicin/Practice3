package part3.part3_2;

public class BankAccount {
    private final String accountNumber;
    private double balance;
    private final String owner;
    private int failedAttempts;
    private boolean blocked;
    private String pin;

    // Конструктор
    public BankAccount(String accountNumber, String owner, String pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.pin = pin;
        this.balance = initialBalance;
        this.failedAttempts = 0;
        this.blocked = false;
    }

    // Геттеры
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    public boolean isBlocked() {
        return blocked;
    }

    // Проверка PIN (нет публичного геттера для pin)
    public boolean validatePin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    // Снятие денег
    public boolean withdraw(String enteredPin, double amount) {
        if (blocked) {
            System.out.println("Ошибка: Счёт заблокирован!");
            return false;
        }

        if (!validatePin(enteredPin)) {
            failedAttempts++;
            System.out.println("Ошибка: Неверный PIN-код! Попытка " + failedAttempts + " из 3");

            if (failedAttempts >= 3) {
                blocked = true;
                System.out.println("ВНИМАНИЕ: Счёт заблокирован из-за 3 неудачных попыток!");
            }
            return false;
        }

        // PIN верный - сбрасываем счётчик
        failedAttempts = 0;

        if (amount <= 0) {
            System.out.println("Ошибка: Сумма должна быть положительной!");
            return false;
        }

        if (amount > balance) {
            System.out.println("Ошибка: Недостаточно средств! Доступно: " + balance + " руб.");
            return false;
        }

        balance -= amount;
        System.out.println("Успешно: Снято " + amount + " руб. Остаток: " + balance + " руб.");
        return true;
    }

    // Пополнение счёта
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Ошибка: Сумма пополнения должна быть положительной!");
            return false;
        }

        balance += amount;
        System.out.println("Успешно: Пополнено на " + amount + " руб. Баланс: " + balance + " руб.");
        return true;
    }

    // Маскированный баланс (скрывает суммы > 100 000)
    public String getMaskedBalance() {
        if (balance > 100_000) {
            return "> 100 000 руб.";
        }
        return balance + " руб.";
    }

    // Изменение PIN-кода (дополнительный метод)
    public boolean changePin(String oldPin, String newPin) {
        if (blocked) {
            System.out.println("Ошибка: Счёт заблокирован!");
            return false;
        }

        if (!validatePin(oldPin)) {
            System.out.println("Ошибка: Неверный старый PIN-код!");
            return false;
        }

        if (newPin == null || newPin.length() < 4) {
            System.out.println("Ошибка: Новый PIN должен содержать минимум 4 символа!");
            return false;
        }

        this.pin = newPin;
        System.out.println("Успешно: PIN-код изменён!");
        return true;
    }

    @Override
    public String toString() {
        String blockedMark = blocked ? " [ЗАБЛОКИРОВАН]" : "";
        return String.format("Счёт: %s | Владелец: %s | Баланс: %s%s",
                accountNumber, owner, getMaskedBalance(), blockedMark);
    }
}
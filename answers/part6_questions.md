# Часть 6: Контрольные вопросы

## 1) В каком порядке выполняются конструкторы при создании объекта подкласса?
Ответ: Конструкторы выполняются от родителя к потомку: сначала вызывается конструктор суперкласса,
затем инициализируются поля подкласса, потом выполняется тело конструктора подкласса.

class Parent {
Parent() { System.out.println("Parent"); }
}
class Child extends Parent {
Child() { System.out.println("Child"); }
}
// new Child() → "Parent" затем "Child"

Ошибка новичка: Забывают вызвать super(...) с параметрами, если у родителя нет конструктора по умолчанию.

## 2) Можно ли переопределить `static` метод? Что такое method hiding?
Ответ: Нельзя переопределить статический метод. Если объявить статический метод с той же сигнатурой
в подклассе — это называется скрытие метода (method hiding).

class Parent {
static void foo() { System.out.println("Parent"); }
void bar() { System.out.println("Parent bar"); }
}
class Child extends Parent {
static void foo() { System.out.println("Child"); }  // скрытие
@Override
void bar() { System.out.println("Child bar"); }     // переопределение
}
Parent p = new Child();
p.foo();  // "Parent" (вызывается метод родителя!)
p.bar();  // "Child bar" (виртуальный вызов)

Ошибка новичка: Думают, что статические методы работают как обычные (виртуально).
На самом деле они привязаны к классу, а не к объекту.

## 3) Что произойдет, если в `switch` нет `default` и ни один `case` не совпал?
Ответ: Программа просто пропустит весь блок switch и продолжит выполнение кода после него.
Никакой ошибки не возникнет.

int day = 5;
switch(day) {
case 1: System.out.println("Mon"); break;
case 2: System.out.println("Tue"); break;
}
// day = 5 → ничего не выведется, программа продолжит работу
System.out.println("После switch");

Ошибка новичка: Думают, что программа упадёт с ошибкой или выбросит исключение.

## 4) Почему в `for-each` нельзя удалять элементы коллекции? Как правильно?
Ответ: for-each использует внутренний итератор, и при удалении элемента коллекция модифицируется,
что вызывает ConcurrentModificationException.

// Способ 1: Iterator
Iterator<String> it = list.iterator();
while(it.hasNext()) {
if(it.next().equals("bad")) it.remove();
}

// Способ 2: removeIf (Java 8+)
list.removeIf(s -> s.equals("bad"));

// Способ 3: обычный for с обратным проходом
for(int i = list.size() - 1; i >= 0; i--) {
if(list.get(i).equals("bad")) list.remove(i);
}

Ошибка новичка: Пытаются удалять прямо в for-each и получают исключение.

## 5) Чем отличается `break` с меткой от обычного `break`?
Ответ: break без метки выходит только из самого внутреннего цикла или switch. break с меткой
выходит из помеченного внешнего блока.

// Обычный break
for(int i = 0; i < 3; i++) {
for(int j = 0; j < 3; j++) {
if(j == 1) break;  // выход только из внутреннего цикла
}
}

// break с меткой
outer:
for(int i = 0; i < 3; i++) {
for(int j = 0; j < 3; j++) {
if(j == 1) break outer;  // выход из ВСЕХ циклов
}
}

Ошибка новичка: Используют метку неправильно (метка должна стоять перед блоком).



## 6) Что означает `@Override`?
Ответ: Аннотация @Override указывает, что метод переопределяет метод суперкласса или реализует метод интерфейса.
Компилятор проверяет, что такой метод действительно существует в родителе.

@Override
public String toString() {
return "MyObject";
}

Ошибка новичка: Если допустить опечатку (toStrng() вместо toString()), без @Override это был бы просто новый метод,
и баг было бы сложнее найти. С @Override компилятор сразу выдаст ошибку.

## 7) Какой модификатор доступа выбрать для видимости в подклассах?
Ответ: protected — поле видно в том же пакете и во всех подклассах (даже в других пакетах),
но не видно в других пакетах вне подклассов.

protected int value;  // виден в подклассах

Ошибка новичка: Используют public (слишком открыто) или private (слишком закрыто).

## 8) Разница между `final` классом и `sealed` классом?
Ответ:
final класс — нельзя наследовать вообще. Это окончательный класс, который не может иметь подклассов.
sealed класс (Java 17+) — можно наследовать, но только тем классам, которые явно перечислены в permits. Это даёт контролируемое наследование.

// final класс
final class Animal {}
// class Cat extends Animal {}  Ошибка компиляции

// sealed класс
sealed class Shape permits Circle, Rectangle {}
final class Circle extends Shape {}      //  разрешено
final class Rectangle extends Shape {}   //  разрешено
// class Triangle extends Shape {}       //  Ошибка: Triangle не в permits

Ошибка новичка: Пытается наследовать от final класса или наследовать sealed класс без указания в permits → ошибка компиляции.

## 9) Можно ли иметь несколько конструкторов?
Ответ: Да, это называется перегрузка конструкторов. Конструкторы различаются по количеству,
типу или порядку параметров.

class Person {
String name;
int age;

    Person() { this("Unknown", 0); }
    Person(String name) { this(name, 0); }
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

Ошибка новичка: Пытаются создать два конструктора с одинаковыми параметрами
(разные имена параметров не считаются).

## 10) Что такое ковариантный тип возвращаемого значения?
Ответ: Ковариантность — это возможность переопределяющего метода возвращать более специфичный (подтип) тип,
чем метод суперкласса.

class Animal {}
class Dog extends Animal {}

class Shelter {
Animal getAnimal() { return new Animal(); }
}

class DogShelter extends Shelter {
@Override
Dog getAnimal() { return new Dog(); }  // ✓ Dog — подтип Animal
}

Ошибка новичка: Пытаются вернуть несвязанный тип (например, String вместо Animal) → ошибка компиляции.
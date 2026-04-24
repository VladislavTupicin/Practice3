package part4.part4_2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShapeTest {
    public static void main(String[] args) {
        System.out.println("Group: ИТ-31");
        System.out.println("Sequence number: 1");
        System.out.println("Date: " + LocalDate.now());
        System.out.println("=".repeat(50));
        System.out.println();

        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle("красный", 5));
        shapes.add(new Rectangle("синий", 4, 6));
        shapes.add(new Square("зелёный", 4));
        shapes.add(new Circle("жёлтый", 3));
        shapes.add(new Rectangle("фиолетовый", 7, 3));

        System.out.println("=== Все фигуры ===");
        for (Shape s : shapes) {
            s.draw();
            System.out.printf("  Площадь: %.2f, Периметр: %.2f%n", s.area(), s.perimeter());
            System.out.println();
        }

        double totalArea = shapes.stream().mapToDouble(Shape::area).sum();
        System.out.printf("Общая площадь всех фигур: %.2f%n", totalArea);

        System.out.println("\n=== Демонстрация полиморфизма ===");
        Shape square = new Square("оранжевый", 10);
        square.draw();
        System.out.println("Площадь квадрата: " + square.area());
        System.out.println("Периметр квадрата: " + square.perimeter());
    }
}
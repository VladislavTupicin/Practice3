package part4.part4_2;

public class Rectangle extends Shape {
    protected double width;
    protected double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        if (width <= 0 || height <= 0) throw new IllegalArgumentException("Стороны должны быть положительными");
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public void draw() {
        System.out.println("Рисую " + color + " прямоугольник " + width + "x" + height);
    }
}
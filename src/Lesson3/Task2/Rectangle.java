package Lesson3.Task2;

public class Rectangle extends Figure{
    private final double a;
    private final double b;

    public Rectangle(String color, String border, double a, double b) {
        super(color, border);
        this.a = a;
        this.b = b;
    }

    @Override
    public double perimeter() {
        return 2 * (a + b);
    }

    @Override
    public double square() {
        return a * b;
    }

    @Override
    public String toString() {
        return "Прямоугольник со сторонами: " + a + "; " + b +
                "; имеет цвет фона: " + getColor() + ", и цвет линии: " + getBorder() + ".\n" +
                "Периметр: " + String.format("%.2f", perimeter()) + ";\nПлощадь: " + String.format("%.2f", square());
    }
}

package Lesson3.Task2;

public class Circle extends Figure{
    private double radius;

    public Circle(String color, String border, double radius) {
        super(color, border);
        this.radius = radius;
    }


    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double square() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Круг с радиусом: " + radius +
                "; имеет цвет фона: " + getColor() + ", и цвет линии: " + getBorder() + ".\n" +
                "Длинна окружности: " + String.format("%.2f", perimeter()) + ";\nПлощадь: " + String.format("%.2f", square());
    }
}

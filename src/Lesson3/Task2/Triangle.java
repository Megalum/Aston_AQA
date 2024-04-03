package Lesson3.Task2;

public class Triangle extends Figure{
    private final double a;
    private final double b;
    private final double c;

    public Triangle(String color, String border, double a, double b, double c) {
        super(color, border);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    private double poluPer(){
        return perimeter() / 2;
    }

    @Override
    public double square() {
        return Math.sqrt(poluPer() * (poluPer() - a) * (poluPer() - b) * (poluPer() - c));
    }

    @Override
    public String toString() {
        return "Треугольник со сторонами: " + a + "; " + b + "; " + c +
                "; имеет цвет фона: " + getColor() + ", и цвет линии: " + getBorder() + ".\n" +
                "Периметр: " + String.format("%.2f", perimeter()) + ";\nПлощадь: " + String.format("%.2f", square());
    }
}

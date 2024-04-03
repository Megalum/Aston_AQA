package Lesson3.Task2;

public abstract class Figure implements Metods {
    private String color;
    private String border;

    public Figure(String color, String border) {
        this.color = color;
        this.border = border;
    }

    @Override
    public String toString() {
        return "Фигура имеет цвет заливки : " + color + ", цвет границы: " + border;
    }

    public String getColor() {
        return color;
    }

    public String getBorder() {
        return border;
    }
}

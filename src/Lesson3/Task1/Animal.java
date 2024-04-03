package Lesson3.Task1;

public class Animal {

    private static long count;
    private String name;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public void run(int count){
        System.out.printf("Пробежал %s\n", count);
    }

    public void sail(int count){
        System.out.printf("Проплыл %s\n", count);
    }

    @Override
    public String toString() {
        return "Животное: " + name;
    }

    public static long getCount() {
        return count;
    }

    public String getName() {
        return name;
    }
}

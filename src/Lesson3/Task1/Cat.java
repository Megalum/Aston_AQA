package Lesson3.Task1;

import java.util.Random;

public class Cat extends Animal {
    private static long food;
    private static long countCat;
    private boolean satiety;
    public Cat(String name) {
        super(name);
        satiety = false;
        countCat++;
    }

    @Override
    public void run(int count){
        String out = count > 200 ? getName() + " устал после 200м" : getName() + " пробежал " + count + "м";
        System.out.println(out);
    }

    @Override
    public void sail(int count){
        System.out.println("Кот не умеет плавать");
    }

    @Override
    public String toString() {
        return "Кот: " + getName();
    }

    public static long getCount() {
        return countCat;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public static long getFood() {
        return food;
    }

    public static void fill(){
        int count = new Random().nextInt(50);
        System.out.printf("В миске %d еды\n", count);
        food = count;
    }

    public static void addFood(int count){
        food += count;
        System.out.printf("В миску добавлено %d еды и теперь в миске %d еды\n", count, food);
    }

    public void eat(int count){
        if (!satiety) {
            System.out.printf("Чтобы поесть коту %s необходимо %d еды\n", getName(), count);
            if (food > count) {
                food -= count;
                satiety = true;
                System.out.printf("Кот %s поел и осталось %d еды\n", getName(), food);
            } else {
                System.out.printf("Коту %s не хватило еды чтобы насытится\n", getName());
            }
        } else {
            System.out.printf("Кот %s уже сыт\n", getName());
        }
    }
}

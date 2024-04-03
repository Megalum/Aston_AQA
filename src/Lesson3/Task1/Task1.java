package Lesson3.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {
    public static void play(){
        System.out.println("Задание №1:");

        List<Animal> list = new ArrayList<>();
        list.add(new Cat("Барсик"));
        list.add(new Dog("Шарик"));
        list.add(new Cat("Рыжик"));
        list.add(new Dog("Жук"));
        list.add(new Dog("Малыш"));

        list.get(0).sail(6);
        list.get(1).sail(6);
        list.get(2).run(50);
        list.get(3).run(600);
        list.get(4).run(400);
        list.get(2).run(300);

        System.out.println();
        System.out.println("Всего котов: " + Cat.getCount());
        System.out.println("Всего собак: " + Dog.getCount());
        System.out.println("Всего животных: " + Animal.getCount());
        System.out.println("\n");

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Барсик"));
        cats.add(new Cat("Рыжик"));
        cats.add(new Cat("Маруся"));
        cats.add(new Cat("Кити"));
        cats.add(new Cat("Серик"));

        Cat.fill();
        for (Cat out: cats){
            int count = new Random().nextInt(10) + 10;
            out.eat(count);
            System.out.println(out + " cытность: " + out.isSatiety() + "\n");
        }

        Cat.addFood(20);
        for (Cat out: cats){
            int count = new Random().nextInt(10) + 10;
            out.eat(count);
            System.out.println(out + " cытность: " + out.isSatiety() + "\n");
        }

    }
}

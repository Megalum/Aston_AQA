package Lesson3.Task2;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void play(){
        System.out.println("Задание №2:");

        List<Figure> list = new ArrayList<>();
        list.add(new Circle("Black", "Blue", 5));
        list.add(new Triangle("White", "Black", 4, 5.6, 6.3));
        list.add(new Rectangle("Grey", "Green", 4, 5.6));
        list.add(new Triangle("Yellow", "Black", 2, 2, 2));
        list.add(new Circle("Green", "Yellow", 15.5));
        list.add(new Rectangle("Black", "Blue", 15, 18));

        for (Figure out: list){
            System.out.println(out + ".\n");
        }
    }
}

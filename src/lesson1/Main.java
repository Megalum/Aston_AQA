package lesson1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание №1: Сообщение в консоль");
        Mathematics.printThreeWords();

        System.out.println("\nЗадание №2: Сумма положительна или отрицательна");
        Mathematics.checkSumSign();

        System.out.println("\nЗадание №3: Вывести цвет");
        Mathematics.printColor();

        System.out.println("\nЗадание №4: Сравнение значений");
        Mathematics.compareNumbers();

        System.out.println("\nЗадание №5: Проверка диапазона суммы");
        if (Mathematics.range(Mathematics.getInt("Введите первое число: "),
                Mathematics.getInt("Введите первое число: "))){
            System.out.println("В пределах диапазона");
        } else {
            System.out.println("За пределами диапазона");
        }

        System.out.println("\nЗадание №6: Проверка на положительность");
        Mathematics.setNumberInfomation(Mathematics.getInt("Введите число: "));

        System.out.println("\nЗадание №7: Проверка на отрицательность");
        if (Mathematics.getNumberInfomation(Mathematics.getInt("Введите число: "))){
            System.out.println("Отрицательное");
        } else {
            System.out.println("Положительное");
        }

        System.out.println("\nЗадание №8: Вывод строки заданное количество раз");
        System.out.print("Введите строку: ");
        Mathematics.printString(new Scanner(System.in).nextLine(),
                Mathematics.getInt("Введите количество раз: "));

        System.out.println("\nЗадание №9: Проверка является ли год високосным");
        if (Mathematics.getYearInfomation(Mathematics.getInt("Введите год: "))){
            System.out.println("Високосный");
        } else {
            System.out.println("Не високосный");
        }

        System.out.println("\nЗадание №10: Заменить (1 на 0) и (0 на 1)");
        Mathematics.replaceArray();

        System.out.println("\n\nЗадание №11: Заполнить значениями массив");
        Mathematics.fillingArray();

        System.out.println("\n\nЗадание №12: В массиве числа меньшие 6 умножить на 2");
        Mathematics.replaceCondition();

        System.out.println("\n\nЗадание №13: В двумерном массиве заполнить диагональные элементы единицами");
        Mathematics.fillingDiagonals();

        System.out.println("\n\nЗадание №14: Метод, который возвращает массив");
        int[] array = Mathematics.getArray(Mathematics.getLen("Введите размерность массива: "),
                Mathematics.getInt("Введите число: "));
        for (Integer o : array) {
            System.out.printf("%s ", o);
        }
    }


}

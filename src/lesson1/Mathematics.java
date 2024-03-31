package lesson1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mathematics {
    private static Scanner scanner = new Scanner(System.in);

    //  метод, который печатает в столбец три слова: Orange, Banana, Apple
    public static void printThreeWords(){
        System.out.println("Orange \nBanana \nApple");
    }

    //  метод суммирует значения и выводит сообщение: “Сумма положительная” или “Сумма отрицательная”
    public static void checkSumSign() {
        int a = getInt("Введите первое число: ");
        int b = getInt("Введите второе число: ");

        if ((a + b) >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }

    }

    /*
        метод который в зависимости от значения выводит цвет:
            v <= 0          - Красный
            0 < v <= 100    - Желтый
            100 < v         - Зелёный
     */
    public static void printColor(){
        int value = getInt("Введите число: ");

        if (value <= 0){
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зелёный");
        }
    }

    //  метод, который сравнивает значения и выводит сообщение: “a >= b” или “a < b”
    public static void compareNumbers(){
        int a = getInt("Введите первое число: ");
        int b = getInt("Введите второе число: ");

        if (a >= b){
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    //  метод проверки диапазона суммы (10 <= (a + b) <= 20)
    public static boolean range(int a, int b){
        int sum = 0;
        try {
            sum = a + b;
        } catch (NumberFormatException e){
            System.out.println("Сумма вышла за пределы Integer!");
        }

        return ((10 <= sum) && (sum <= 20));
    }

    //  метод, который выводив сообщение: "Положительное" или "Отрицательное" передаваемое число
    public static void setNumberInfomation(int value){
        if (value >= 0){
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    //  метод, который возвращает: true, если число отрицательное, или false, если положительное
    public static boolean getNumberInfomation(int value){
        return (value < 0);
    }

    //  метод, который отпечатывает в консоль указанную строку, указанное количество раз
    public static void printString(String text, int len){
        for (int i = 0; i < len; i++) {
            System.out.println(text);
        }
    }

    //  метод, который определяет, является ли год високосным
    public static boolean getYearInfomation(int year){
        return ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)));
    }

    //  метод, который меняет местами 0 и 1
    public static void replaceArray(){
        int[] array = new int[Mathematics.getLen("Введите размерность массива: ")];
        System.out.println("Исходный массив:");
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(2);
            System.out.print(array[i] + " ");
        }
        System.out.println("\nИзмененный массив:");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
            System.out.print(array[i] + " ");
        }
    }

    //  метод, заполняющий массив числами по порядку
    public static void fillingArray(){
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
            System.out.print(array[i] + " ");
        }
    }

    //метод, который в массиве числа меньшие 6 умножает на 2
    public static void replaceCondition(){
        int[] array = new int[]{ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println("Исходный массив:");
        for (Integer o: array){
            System.out.print(o + " ");
        }
        System.out.println("\nИзмененный массив: ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6){
                array[i] *= 2;
            }
            System.out.print(array[i] + " ");
        }
    }

    //  метод, который возвращает массив
    public static void fillingDiagonals(){
        int len = getLen("Введите размерность квадратной матрицы:");
        int[][] matrix = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if ((i == j) || (i + j + 1 == len)) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //  метод, который возвращает одномерный массив
    public static int[] getArray(int len, int initialValue){
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    //  метод ввода целого числа
    public static int getInt(String str){
        String num;
        while (true){
            try {
                System.out.print(str);
                num = scanner.nextLine();
                if (isNumber(num)) {
                    return Integer.parseInt(num);
                }
                System.out.println("Не число!");
            } catch (NumberFormatException e){
                System.out.println("Выход за пределы Integer!");
            }
        }
    }

    //  метод ввода размерности
    public static int getLen(String str){
        int len;
        while (true) {
            len = getInt(str);
            if (len > 0) {
                return len;
            }
            System.out.println("Длинна не может быть отрицательной!");
        }
    }

    //  метод проверки на целое число
    private static boolean isNumber(String str){
        return str.matches("-?\\d+?");
    }

}

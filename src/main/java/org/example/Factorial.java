package org.example;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        long result = run(getNumber());
        System.out.println("Результат факториала: " + result);
    }

    private static Scanner scanner = new Scanner(System.in);
    public static int getNumber(){
        System.out.println("Введите число: ");
        int number;
        if (scanner.hasNextInt()){
            number = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз");
            if (scanner.hasNextInt()) {
                scanner.next();

                number = getNumber();
            } else {
                throw new IllegalStateException("Ошибка в вводимых данных");
            }
        }
        return number;
    }

    public static long run(int number){
        if (number < 0){
            throw new IllegalStateException("Ошибка. Факториал не может быть отрицательным!");
        }
        long result = 1;

        for(int i = 1; i <= number; i++){
            result *= i;
        }

        return result;
    }
}
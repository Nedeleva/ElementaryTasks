package com.softserve.nedeleva.fibonacci_numbers;

import java.util.Scanner;

/**
 * Программа позволяет вывести все числа Фибоначчи,
 * которые находятся в указанном диапазоне.
 * Диапазон задаётся двумя аргументами при вызове главного класса.
 * Числа выводятся через запятую по возрастанию.
 */
public class FibonacciNumbers {

    private static void createAndPrintFibonacciNumbers(int startRange, int endRange) {
        int f1 = 0;
        int f2 = 1;
        int f3 = 0;
        int x[] = new int[100];
        for (int i = 0; i < endRange; i++) {
            x[i] = f3;
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        for (int j = startRange; j < endRange; j++) {
            System.out.print(x[j] + ", ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startRange = sc.nextInt();
        int endRange = sc.nextInt();
        FibonacciNumbers.createAndPrintFibonacciNumbers(startRange, endRange);
    }
}

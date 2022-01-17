package com.softserve.nedeleva.numeric_sequence;

import java.util.Scanner;

/**
 * Программа выводит ряд натуральных чисел через запятую,
 * квадрат которых меньше заданного n.
 * Программа запускается через вызов главного класса с параметрами.
 */
public class NumericSequence {
    private static void numSequence(int number, int endRange) {
        System.out.print(1);
        for (int i = 2; i < endRange; i++) {
            System.out.print((Math.sqrt(i) < number) ? ", " + i : " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int endRange = sc.nextInt();
        NumericSequence.numSequence(number, endRange);
    }
}

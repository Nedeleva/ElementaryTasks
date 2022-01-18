package com.softserve.nedeleva.num_to_words;

import java.util.Scanner;

/**
 * Нужно преобразовать целое число в прописной вариант: 12 – двенадцать.
 * Программа запускается через вызов главного класса с параметрами.
 */
public class NumbersToWords {

    private static final String[] LESS_THAN_TWENTY = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцадь", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
    private static final String[] TENS = {"сто", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};

    static void numToWords(int number) {
        if (number < 0 || number > 100) {
            System.out.println("Error. The number is out of bounds");
        }
        if (number < 20) {
            System.out.println(LESS_THAN_TWENTY[number]);
        } else if (number < 100) {
            int firstPart = number / 10;
            int secondPart = number % 10;
            String wordResult = TENS[firstPart];
            if (secondPart != 0) {
                wordResult = wordResult + " " + LESS_THAN_TWENTY[secondPart];
            }
            System.out.println(wordResult);
        } else {
            System.out.println(TENS[0]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        NumbersToWords.numToWords(num);
    }
}

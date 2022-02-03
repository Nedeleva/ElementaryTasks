package com.softserve.nedeleva.num_to_words;

import java.util.Scanner;

/**
 * Нужно преобразовать целое число в прописной вариант: 12 – двенадцать.
 * Программа запускается через вызов главного класса с параметрами.
 */
public class NumbersToWords {

    private static final String[] LESS_THAN_TWENTY = {" ", "ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцадь", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
    private static final String[] TENS = {" ", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private static final String[] HUNDREDS = {" ", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    private static final String[] THOUSAND = {" ", "тысяча", "тысячи", "тысяч"};
    private static final String[] OTHERS = {"одна", "две"};

    private static void numLessThanThousand(int number) {
        if (number < 0) {
            System.out.println("Error. The number is out of bounds");
        }
        if (number < 20) {
            System.out.println(LESS_THAN_TWENTY[number + 1]);
        } else if (number < 100) {
            int firstPart = number / 10;
            int secondPart = number % 10;
            String wordResult = TENS[firstPart];
            if (secondPart != 0) {
                wordResult = wordResult + " " + LESS_THAN_TWENTY[secondPart + 1];
            }
            System.out.println(wordResult);
        } else if (number == 100) {
            System.out.println(HUNDREDS[1]);
        } else if (number < 1000) {
            int firstPart = number / 100;
            int secondPart = number / 10 % 10;
            int thirdPart = number % 10;
            String wordResult1 = HUNDREDS[firstPart] + " " + TENS[secondPart] + " " + LESS_THAN_TWENTY[thirdPart + 1];
            System.out.println(wordResult1);
        }
    }

    private static void numMoreThanHundreds(int number) {
        if (number == 1000) {
            System.out.println(OTHERS[0] + " " +THOUSAND[1]);
        } else if (number > 1000 && number < 10000) {
            int firstPart = number / 1000;
            int secondPart = number / 100 % 10;
            int thirdPart = number / 10 % 10;
            int fourthPart = number % 10;
            if (firstPart == 1 && secondPart != 0 && thirdPart != 0 && fourthPart != 0) {
                System.out.println(OTHERS[0] + " " + THOUSAND[1] + " " + HUNDREDS[secondPart] + " " + TENS[thirdPart] + " " + LESS_THAN_TWENTY[fourthPart + 1]);
            }
            if (firstPart == 2 && secondPart != 0 && thirdPart != 0 && fourthPart != 0) {
                System.out.println(OTHERS[1] + " " + THOUSAND[2] + " " + HUNDREDS[secondPart] + " " + TENS[thirdPart] + " " + LESS_THAN_TWENTY[fourthPart + 1]);
            }
            if (firstPart > 2 && firstPart < 5 && secondPart != 0 && thirdPart != 0 && fourthPart != 0) {
                System.out.println(LESS_THAN_TWENTY[firstPart + 1] + " " + THOUSAND[2] + " " + HUNDREDS[secondPart] + " " + TENS[thirdPart] + " " + LESS_THAN_TWENTY[fourthPart + 1]);
            }
            if (firstPart >= 5 && secondPart != 0 && thirdPart != 0 && fourthPart != 0) {
                System.out.println(LESS_THAN_TWENTY[firstPart + 1] + " " + THOUSAND[3] + " " + HUNDREDS[secondPart] + " " + TENS[thirdPart] + " " + LESS_THAN_TWENTY[fourthPart + 1]);
            }
            if (firstPart == 2 && secondPart == 0 && thirdPart == 0 && fourthPart == 0) {
                System.out.println(OTHERS[1] + " " + THOUSAND[2]);
            }
            if (firstPart > 2 && firstPart < 5 && secondPart == 0 && thirdPart == 0 && fourthPart == 0) {
                System.out.println(LESS_THAN_TWENTY[firstPart + 1] + " " + THOUSAND[2]);
            }
            if (firstPart >= 5 && secondPart == 0 && thirdPart == 0 && fourthPart == 0) {
                System.out.println(LESS_THAN_TWENTY[firstPart + 1] + " " + THOUSAND[3]);
            }
            if (firstPart == 1 && secondPart == 0 && thirdPart != 0 && fourthPart != 0) {
                System.out.println(OTHERS[0] + " " + THOUSAND[1] +" " + TENS[thirdPart] + " " + LESS_THAN_TWENTY[fourthPart + 1]);
            }
            if (firstPart == 2 && secondPart == 0 && thirdPart != 0 && fourthPart != 0) {
                System.out.println(OTHERS[1] + " " + THOUSAND[2] + " " + TENS[thirdPart] + " " + " " + LESS_THAN_TWENTY[fourthPart + 1]);
            }
            if (firstPart > 2 && firstPart < 5 && secondPart == 0 && thirdPart != 0 && fourthPart != 0) {
                System.out.println(LESS_THAN_TWENTY[firstPart + 1] + " " + THOUSAND[2] + " " + TENS[thirdPart] + " " + LESS_THAN_TWENTY[fourthPart + 1]);
            }
            if (firstPart >= 5 && secondPart == 0 && thirdPart != 0 && fourthPart != 0) {
                System.out.println(LESS_THAN_TWENTY[firstPart + 1] + " " + THOUSAND[3] + " " + TENS[thirdPart] + " " + LESS_THAN_TWENTY[fourthPart + 1]);
            }
            if (firstPart == 1 && secondPart != 0 && thirdPart == 0 && fourthPart == 0) {
                System.out.println(OTHERS[0] + " " + THOUSAND[1] + " " + HUNDREDS[secondPart]);
            }
            if (firstPart == 2 && secondPart != 0 && thirdPart == 0 && fourthPart == 0) {
                System.out.println(OTHERS[1] + " " + THOUSAND[1] + " " + HUNDREDS[secondPart]);
            }
            if (firstPart > 2 && firstPart < 5 && secondPart != 0 && thirdPart == 0 && fourthPart == 0) {
                System.out.println(LESS_THAN_TWENTY[firstPart + 1] + " " + THOUSAND[1] + " " + HUNDREDS[secondPart]);
            }
            if (firstPart >= 5 && secondPart != 0 && thirdPart == 0 && fourthPart == 0) {
                System.out.println(LESS_THAN_TWENTY[firstPart + 1] + " " + THOUSAND[3] + " " + HUNDREDS[secondPart]);
            }
            if (firstPart == 1 && secondPart == 0 && thirdPart == 0 && fourthPart != 0) {
                System.out.println(OTHERS[0] + " " + THOUSAND[1] + " " + LESS_THAN_TWENTY[fourthPart + 1]);
            }
            if (firstPart == 2 && secondPart == 0 && thirdPart == 0 && fourthPart != 0) {
                System.out.println(OTHERS[1] + " " + THOUSAND[1] + " " + LESS_THAN_TWENTY[fourthPart + 1]);
            }
            if (firstPart > 2 && firstPart < 5 && secondPart == 0 && thirdPart == 0 && fourthPart != 0) {
                System.out.println(LESS_THAN_TWENTY[firstPart + 1] + " " + THOUSAND[1] + " " + LESS_THAN_TWENTY[fourthPart + 1]);
            }
            if (firstPart >= 5 && secondPart == 0 && thirdPart == 0 && fourthPart != 0) {
                System.out.println(LESS_THAN_TWENTY[firstPart + 1] + " " + THOUSAND[3] + " " + LESS_THAN_TWENTY[fourthPart + 1]);
            }
            if (firstPart == 1 && secondPart != 0 && thirdPart != 0 && fourthPart == 0) {
                System.out.println(OTHERS[0] + " " + THOUSAND[1] + " " + HUNDREDS[secondPart] + " " + TENS[thirdPart]);
            }
            if (firstPart == 2 && secondPart != 0 && thirdPart != 0 && fourthPart == 0) {
                System.out.println(OTHERS[1] + " " + THOUSAND[1] + " " + HUNDREDS[secondPart] + " " + TENS[thirdPart]);
            }
            if (firstPart > 2 && firstPart < 5 && secondPart != 0 && thirdPart != 0 && fourthPart == 0) {
                System.out.println(LESS_THAN_TWENTY[firstPart + 1] + " " + THOUSAND[1] + " " + HUNDREDS[secondPart] + " " + TENS[thirdPart]);
            }
            if (firstPart > 5 && secondPart != 0 && thirdPart != 0 && fourthPart == 0) {
                System.out.println(LESS_THAN_TWENTY[firstPart + 1] + " " + THOUSAND[3] + " " + HUNDREDS[secondPart] + " " + TENS[thirdPart]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number < 1000) {
            NumbersToWords.numLessThanThousand(number);
        } else {
            NumbersToWords.numMoreThanHundreds(number);
        }
    }
}

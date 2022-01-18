package com.softserve.nedeleva.envelope_analysis;

import java.util.Scanner;

/**
 * Есть два конверта со сторонами (a,b) и (c,d) определить, можно ли один конверт вложить в другой.
 * Программа должна обрабатывать ввод чисел с плавающей точкой.
 * Программа спрашивает у пользователя размеры конвертов по одному параметру за раз.
 * После каждого подсчёта программа спрашивает у пользователя хочет ли он продолжить.
 * Если пользователь ответит “y” или “yes” (без учёта регистра),
 * программа продолжает работу сначала, в противном случае – завершает выполнение.
 */
public class EnvelopeAnalysis {
    private static Scanner sc = new Scanner(System.in);
    private static Envelope firstEnvelope = new Envelope();
    private static Envelope secondEnvelope = new Envelope();

    private static void readEnvelope(Envelope firstEnvelope, Envelope secondEnvelope) {
        double firstSideA = sc.nextDouble();
        double firstSideB = sc.nextDouble();
        double secondSideC = sc.nextDouble();
        double secondSideD = sc.nextDouble();
        firstEnvelope.firstSide = firstSideA;
        firstEnvelope.secondSide = firstSideB;
        secondEnvelope.firstSide = secondSideC;
        secondEnvelope.secondSide = secondSideD;
    }

    private static void solution() {
        String answer;
        do {
            readEnvelope(firstEnvelope, secondEnvelope);
            switch (firstEnvelope.compareTo(secondEnvelope)) {
                case 1:
                    System.out.println("Second envelope can be put into first");
                    break;
                case -1:
                    System.out.println("First envelope can be put into second");
                    break;
                case 0:
                    System.out.println("Envelopes cannot be put into each other");
                    break;
            }
            System.out.println("Do you want to add another envelopes? (y/yes or n/no)");
            sc.nextLine();
            answer = sc.nextLine();
        }
        while (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes"));
    }

    public static void main(String[] args) {
        EnvelopeAnalysis.solution();
    }
}

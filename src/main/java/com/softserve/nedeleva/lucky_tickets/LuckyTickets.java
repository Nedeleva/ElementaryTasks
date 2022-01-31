package com.softserve.nedeleva.lucky_tickets;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Счастливые билеты.
 * Есть 2 способа подсчёта счастливых билетов:
 * 1. Московский — если на автобусном билете напечатано шестизначное число,
 * и сумма первых трёх цифр равна сумме последних трёх,
 * то этот билет считается счастливым.
 * 2. Ленинградский, или Питерский — если сумма чётных цифр билета
 * равна сумме нечётных цифр билета,
 * то билет считается счастливым.
 * Задача:
 * Номер билета - шестизначное число. Нужно написать консольное приложение,
 * которое может посчитать количество счастливых билетов. Для выбора алгоритма подсчёта читается текстовый файл. Путь к текстовому файлу задаётся в консоли после запуска программы. Индикаторы алгоритмов:
 * 1 - слово 'Moskow' 2 - слово 'Piter'
 * После задания всех необходимых параметров,
 * программа в консоль должна вывести количество счастливых билетов для указанного способа подсчёта.
 */
public class LuckyTickets {

    private static final String FILE_PATH = "/Users/delitelnula/Documents/SoftServe/ElementaryTasks/src/main/resources/LuckyTicket.txt";

    private static List<String> listOfTickets(String filePath) throws IOException {
        Scanner sc = new Scanner(new File(filePath));
        List<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            lines.add(String.valueOf(sc.nextLine()));
        }
        return lines;
    }

    private static boolean isLuckyByMoscowType(String str) {
        int sumFirstPart = 0;
        int sumSecondPart = 0;
        for (int i = 0; i < str.length() / 2; i++) {
            sumFirstPart += Character.getNumericValue(str.charAt(i));
            sumSecondPart += Character.getNumericValue((str.charAt(str.length() - i - 1)));
        }
        return sumFirstPart == sumSecondPart;
    }

    private static boolean isLuckyByPiterType(String str) {
        int sumFirstPart = 0;
        int sumSecondPart = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) % 2 == 0) {
                sumFirstPart += Character.getNumericValue(str.charAt(i));
            }
            if (str.charAt(i) % 2 == 1)
                sumSecondPart += Character.getNumericValue(str.charAt(i));
        }
        return sumFirstPart == sumSecondPart;
    }

    private static void listOfLuckyTickets(List<String> tickets, String type) {
        if (type.equals("Moscow")) {
            System.out.println("Lucky tickets by Moscow type:");
            for (int i = 0; i < tickets.size(); i++) {
                if (isLuckyByMoscowType(tickets.get(i))) {
                    System.out.println(tickets.get(i));
                }
            }
        }
        if (type.equals("Piter")) {
            System.out.println("Lucky tickets by Piter type:");
            for (int i = 0; i < tickets.size(); i++) {
                if (isLuckyByPiterType(tickets.get(i))) {
                    System.out.println(tickets.get(i));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the type: (Moscow or Piter)");
        String type = scanner.nextLine();
        List<String> tickets = LuckyTickets.listOfTickets(FILE_PATH);
        LuckyTickets.listOfLuckyTickets(tickets, type);
    }
}


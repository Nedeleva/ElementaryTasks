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
 * которое может посчитать количество счастливых билетов. Для выбора алгоритма подсчёта читается текстовый файл.
 * Путь к текстовому файлу задаётся в консоли после запуска программы.
 * Индикаторы алгоритмов:
 * 1 - слово 'Moscow' 2 - слово 'Piter'
 * После задания всех необходимых параметров,
 * программа в консоль должна вывести количество счастливых билетов для указанного способа подсчёта.
 */
public class LuckyTickets {

    public static List<String> getListOfFileContent(String filePath) throws IOException {
        Scanner in = new Scanner(new File(filePath));
        List<String> lines = new ArrayList<>();
        while (in.hasNextLine()) {
            lines.add(String.valueOf(in.nextLine()));
        }
        return lines;
    }

    public static void getListOfLuckyTicketsByType(List<String> tickets, String type) {
        List<String> listOfLuckyTickets = new ArrayList<>();
        for (String ticket : tickets) {
            switch (type) {
                case "Moscow" -> {
                    if (LuckyProperties.isLuckyByMoscowType(ticket)) {
                        listOfLuckyTickets.add(ticket);
                    }
                }
                case "Piter" -> {
                    if (LuckyProperties.isLuckyByPiterType(ticket)) {
                        listOfLuckyTickets.add(ticket);
                    }
                }
            }
        }
        if (listOfLuckyTickets.size() > 0) {
            System.out.println("Number of lucky tickets by " + type + " type: " + listOfLuckyTickets.size());
            System.out.println("List of lucky tickets by " + type + " type: " + listOfLuckyTickets);
        } else {
            System.out.println("No lucky tickets of given type");
        }
    }
}


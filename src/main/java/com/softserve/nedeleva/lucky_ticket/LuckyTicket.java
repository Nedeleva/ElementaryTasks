package com.softserve.nedeleva.lucky_ticket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
public class LuckyTicket {

    private static List numOfLuckyTcket(String filePath, String type) throws IOException {
        Scanner sc = new Scanner(new File(filePath));
        List<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        return lines;
    }

    private static int numOfLuckyTcket1(List tickets, String type) {
        int numOfLuckTickets = 0;
        int count=0;
        int sum=0;
        String str1=null;
        String str;
        if (type == "Moskow") {
            for (int i = 0; i < tickets.size(); i++) {
                str = tickets.get(i).toString();
                int mid = str.length() / 2; //get the middle of the String
                String[] parts = {str.substring(0, mid),str.substring(mid)};
                str1 = String.join(", ", parts);
                for (int j = 0; j < str1.length(); j++) {
                    if (Character.isDigit(str1.charAt(i))) {
                        count++;
                        sum += Integer.parseInt(String.valueOf(str1.charAt(i)));
                       // System.out.println(sum);
                    }
                }
                if (parts[0].equals(parts[1])){
                    numOfLuckTickets++;
                }
            }
            System.out.println(sum);
            System.out.println(str1);
        }
        if (type == "Piter"){
            System.out.println("In progress..");
        }
        return numOfLuckTickets;
    }


    ///Users/delitelnula/Downloads/LuckyTicket.txt
    public static void main(String[] args) throws IOException {
        List d = LuckyTicket.numOfLuckyTcket("/Users/delitelnula/Downloads/LuckyTicket.txt", "Moskow");
        int res = LuckyTicket.numOfLuckyTcket1(d,"Moskow");
        System.out.println(res);
    }

}


package com.softserve.nedeleva.file_parser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Нужно написать программу, которая будет иметь два режима:
 * 1. Считать количество вхождений строки в текстовом файле.
 * 2. Делать замену строки на другую в указанном файле.
 * Программа должна принимать аргументы на вход при запуске:
 * 1. <путь к файлу> <строка для подсчёта>
 * 2. <путь к файлу> <строка для поиска> <строка для замены>
 */
public class FileParser {

    private static void countNumberOfOccurrences(String filePath, int lineNumber) throws IOException {
        String line = Files.readAllLines(Paths.get(filePath)).get(lineNumber);
        int numberOfOccurrences = (int) Arrays.stream(line.split(" ")).count();
        System.out.println(numberOfOccurrences);
    }

    private static void changeSearchLineToNewLine(String filePath, String searchLine, String newLine) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line.replace(searchLine, newLine)).append("\n");
        }
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(sb.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Укажите путь к файлу:");
        String filePath = sc.nextLine();
        System.out.println("Укажите номер строки для подсчета(счет с нуля):");
        int lineNumber = sc.nextInt();
        System.out.println("Количество слов в строке:");
        FileParser.countNumberOfOccurrences(filePath, lineNumber);
//        System.out.println("Введите строку для поиска:");
//        String searchLine = sc.nextLine();
//        System.out.println("Введите строку для замены:");
//        String newLine = sc.nextLine();
//        FileParser.changeSearchLineToNewLine(filePath, searchLine, newLine);
    }
}
package com.softserve.nedeleva.file_parser;

import java.io.*;
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

    private static final String FILE_PATH = "/Users/delitelnula/Documents/SoftServe/ElementaryTasks/src/main/resources/Hello.txt";

    private static void countNumberOfOccurrences(String fileName, String mark) throws IOException {
        String line;
        int count = 0;
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            if (line.contains(mark)) {
                count++;
            }
        }
        System.out.println(count);
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

    private static void solution() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Specify a word to count occurrences:");
        String mark = sc.nextLine();
        System.out.println("Number of occurrences in the file:");
        FileParser.countNumberOfOccurrences(FILE_PATH, mark);
        do {
            System.out.println("Enter a search line:");
            String searchLine = sc.nextLine();
            System.out.println("Enter a line to replace:");
            String newLine = sc.nextLine();
            FileParser.changeSearchLineToNewLine(FILE_PATH, searchLine, newLine);
        } while (!sc.hasNextLine());
    }

    public static void main(String[] args) throws IOException {
        FileParser.solution();
    }
}
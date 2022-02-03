package com.softserve.nedeleva.lucky_tickets;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String FILE_PATH = "/Users/delitelnula/Documents/SoftServe/ElementaryTasks/src/main/resources/LuckyTicket.txt";

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose the type: (Moscow or Piter)");
        String type = in.nextLine();
        List<String> content = LuckyTickets.getListOfFileContent(FILE_PATH);
        LuckyTickets.getListOfLuckyTicketsByType(content, type);
    }
}

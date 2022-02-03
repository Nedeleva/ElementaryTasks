package com.softserve.nedeleva.triangle_sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SortTrianglesByTheMap {

    public static Scanner in = new Scanner(System.in);

    public static void readAndCreateListOfTriangles() {
        String answer;
        Map<String, Double> map = new HashMap<>();
        do {
            String name = in.nextLine();
            double side1 = in.nextDouble();
            double side2 = in.nextDouble();
            double side3 = in.nextDouble();
            Triangle triangle = new Triangle(name, side1, side2, side3);
            map.put(triangle.getName(), triangle.getArea());
            System.out.println("Do you want to add one more?");
            in.nextLine();
            answer = in.nextLine();
            map.entrySet().stream()
                    .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                    .forEach(System.out::println);
        }
        while (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes"));
    }

    public static void main(String[] args) {
        SortTrianglesByTheMap.readAndCreateListOfTriangles();
    }
}

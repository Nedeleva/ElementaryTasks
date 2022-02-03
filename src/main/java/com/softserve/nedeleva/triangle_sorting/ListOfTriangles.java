package com.softserve.nedeleva.triangle_sorting;

import java.util.*;

/**
 * Разработать консольную программу, выполняющую вывод треугольников в порядке убывания их площади.
 * После добавления каждого нового треугольника программа спрашивает, хочет ли пользователь добавить ещё один.
 * Если пользователь ответит “y” или “yes” (без учёта регистра), программа попросит ввести данные для ещё одного треугольника, в противном случае – выводит результат в консоль.
 * • Расчёт площади треугольника должен производится по формуле Герона.
 * • Каждый треугольник определяется именем и длинами его сторон.
 * Формат ввода (разделитель - запятая):
 * <имя>, <длина стороны>, <длина стороны>, <длина стороны>
 * • Приложение должно обрабатывать ввод чисел с плавающей точкой.
 * • Ввод должен быть нечувствителен к регистру, пробелам, табам.
 * • Вывод данных должен быть следующем примере:
 * ============= Triangles list: ===============
 * 1. [Triangle first]: 17.23 сm
 * 2. [Triangle 22]: 13 cm
 * 3. [Triangle 1]: 1.5 cm
 */
public class ListOfTriangles {

    public static Scanner in = new Scanner(System.in);

    public static Triangle createTriangle() {
        System.out.println("Specify the name for the triangle:");
        String name = in.nextLine();
        System.out.println("Specify the first side:");
        double firstSide = in.nextDouble();
        System.out.println("Specify the second side:");
        double secondSide = in.nextDouble();
        System.out.println("Specify the third side:");
        double thirdSide = in.nextDouble();
        return new Triangle(name, firstSide, secondSide, thirdSide);
    }

    public static void printTriangle(Triangle triangle) {
        System.out.println("[" + triangle.getName() + "]: " + triangle.getArea() + " сm");
    }

    public static void getSortingListOfTriangles() {
        List<Triangle> triangles = new ArrayList<>();
        String answer;
        do {
            triangles.add(createTriangle());
            System.out.println("Do you want to add another triangle? (y/yes or n/no)");
            in.nextLine();
            answer = in.nextLine();
        }
        while (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes"));
        triangles.sort(Comparator.comparing(Triangle::getArea));
        Collections.reverse(triangles);

        System.out.println("============= Triangles list: ===============");
        for (Triangle triangle : triangles) {
            if (triangle.getArea() > 0) {
                printTriangle(triangle);
            }
        }
    }

    public static void main(String[] args) {
        ListOfTriangles.getSortingListOfTriangles();
    }
}

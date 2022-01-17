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

    private static Scanner sc = new Scanner(System.in);

    private static Triangle readTriangle() {
        String name = sc.nextLine();
        double firstSide = sc.nextDouble();
        double secondSide = sc.nextDouble();
        double thirdSide = sc.nextDouble();
        return new Triangle(name, firstSide, secondSide, thirdSide);
    }

    private static void createTriangle(Triangle triangle) {
        System.out.println("[" + triangle.getName() + "]: " + triangle.getSquare() + " сm");
    }

    private static void solution() {
        List<Triangle> triangles = new ArrayList<>();
        String answer = "y";
        do {
            triangles.add(readTriangle());
            System.out.println("Do you want to add another triangle? (y/yes or n/no)");
            answer = sc.nextLine();
            answer = sc.nextLine();
        }
        while (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes"));
        triangles.sort(Comparator.comparing(Triangle::getSquare));
        Collections.reverse(triangles);

        for (int i = 0; i < triangles.size(); i++) {
            createTriangle(triangles.get(i));
        }
    }

    public static void main(String[] args) {
        ListOfTriangles.solution();
    }
}

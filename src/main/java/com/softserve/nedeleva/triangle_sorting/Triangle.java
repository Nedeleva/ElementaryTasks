package com.softserve.nedeleva.triangle_sorting;

public class Triangle {
    public String name;
    public double firstSide;
    public double secondSide;
    public double thirdSide;

    public Triangle(String name, double firstSide, double secondSide, double thirdSide) {
        if (firstSide + secondSide < thirdSide || firstSide + thirdSide < secondSide || thirdSide + secondSide < firstSide) {
            System.out.println("Incorrect values. Please try again");
        }
        this.name = name;
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        double p = (firstSide + secondSide + thirdSide) / 2;
        return Math.sqrt(p * (p - firstSide) * (p - secondSide) * (p - thirdSide));
    }
}

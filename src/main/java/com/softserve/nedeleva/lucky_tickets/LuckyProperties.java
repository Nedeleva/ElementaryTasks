package com.softserve.nedeleva.lucky_tickets;

public class LuckyProperties {

    public static boolean isLuckyByMoscowType(String str) {
        int sumFirstPart = 0;
        int sumSecondPart = 0;
        for (int i = 0; i < str.length() / 2; i++) {
            sumFirstPart += Character.getNumericValue(str.charAt(i));
            sumSecondPart += Character.getNumericValue((str.charAt(str.length() - i - 1)));
        }
        if (str.length() != 6) {
            return false;
        }
        return sumFirstPart == sumSecondPart;
    }

    public static boolean isLuckyByPiterType(String str) {
        int sumEvenPart = 0;
        int sumOddPart = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) % 2 == 0) {
                sumEvenPart += Character.getNumericValue(str.charAt(i));
            }
            if (str.charAt(i) % 2 == 1) {
                sumOddPart += Character.getNumericValue(str.charAt(i));
            }
        }
        if (str.length() != 6) {
            return false;
        }
        return sumEvenPart == sumOddPart;
    }
}

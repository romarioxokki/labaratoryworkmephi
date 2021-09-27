package com.company;

import java.util.Scanner;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Locale;

public class Main {
    static final Pattern PATTERNSPLIT = Pattern.compile("-?\\d+(\\.\\d+)?");
    static final Pattern PATTERN = Pattern.compile("-?\\d+(\\.\\d+)? -?\\d+(\\.\\d+)?.*");
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str;
        do {
            System.out.print("Input string: ");
            str = sc.nextLine();
            if (str.length() >= 17) {
                System.out.println(" The input is too long ");
                continue;
            }
            if (str.equals("q")) {
                System.out.print("Game over!");
                return;
            }
            if (str.equals("--h")) {
                System.out.println("About function");
                continue;
            }
            if (isNumeric(str)) {
                double numb = Double.parseDouble(str);
                double square = numb * numb;
                System.out.format(Locale.US,"%.3f\n", square);
                double cube = Math.cbrt(numb);
                System.out.format(Locale.US,"%.3f\n", cube);
                continue;
            }
            float[] value = new float[2];
            if (isTwoNumbers(str)) {
                float[] values = splitTwoNumbers(str);
                if (value[1] == 0) {
                    System.out.println("Cannot be divided by 0");
                    continue;
                }
                System.out.format(Locale.US,"%.3f%n",  value[0] / value[1]);
                continue;
            }
            int ans = countUniqueCharacters(str);
            char[] array = str.toCharArray();
            Arrays.sort(array);
            System.out.println(array);
            System.out.println(ans);
        } while (true);
    }

    public static boolean isTwoNumbers(String str) {
        if (str == null) return false;
        // extract into a constant

        if (!PATTERN.matcher(str).matches()) return false;

        return true;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static float[] splitTwoNumbers(String str) {
        float[] numbers = new float[2];
        Matcher matcher = PATTERNSPLIT.matcher(str);
        for (int i = 0; i < 2; i++) {
            matcher.find();
            numbers[i] = Float.parseFloat(str.substring(matcher.start(), matcher.end()));
        }
        return numbers;
    }

    public static int countUniqueCharacters(String input) {
        boolean[] isItThere = new boolean[Character.MAX_VALUE];
        for (int i = 0; i < input.length(); i++) {
            isItThere[input.charAt(i)] = true;
        }

        int count = 0;
        for (int i = 0; i < isItThere.length; i++) {
            if (isItThere[i] == true) {
                count++;
            }
        }

        return count;
    }


}

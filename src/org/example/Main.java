package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 500;
        List<String> result = sequence(n);
        System.out.println(result);

        //-----

        String str = "make install";
        String reversedStr = reverseString(str);
        System.out.println(reversedStr);

        //----

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите коэффициент a: ");
        double a = scanner.nextDouble();

        System.out.print("Введите коэффициент b: ");
        double b = scanner.nextDouble();

        System.out.print("Введите коэффициент c: ");
        double c = scanner.nextDouble();

        solveQuadraticEquation(a, b, c);

        //----

        // Проверка строки на палиндром
        System.out.print("Введите строку для проверки на палиндром: ");
        scanner.nextLine(); // Очистка буфера после предыдущего ввода
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Строка является палиндромом.");
        } else {
            System.out.println("Строка не является палиндромом.");
        }

        scanner.close();

        //----
    }

    public static List<String> sequence(int n) {
        if (n <= 0)
            return null;

        List<String> sequence = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0) {
                if (i % 7 == 0)
                    sequence.add("fizzbuzz");
                else
                    sequence.add("fizz");
            } else if (i % 7 == 0) {
                sequence.add("buzz");
            } else
                sequence.add(String.valueOf(i));
        }

        return sequence;
    }

    // Функция для переворота строки
    public static String reverseString(String str) {
        String reversedStr = "";

        // Проходим по строке с конца к началу
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedStr += str.charAt(i);
        }

        return reversedStr;
    }

    // Функция для решения квадратного уравнения
    public static void solveQuadraticEquation(double a, double b, double c) {
        // Вычисляем дискриминант
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Уравнение имеет два вещественных корня:");
            System.out.println("Корень 1: " + root1);
            System.out.println("Корень 2: " + root2);
        } else if (discriminant == 0) {
            // Один вещественный корень (кратный)
            double root = -b / (2 * a);
            System.out.println("Уравнение имеет один вещественный корень:");
            System.out.println("Корень: " + root);
        } else {
            // Нет вещественных корней
            System.out.println("Нет вещественных корней.");
        }
    }

    // Функция для проверки, является ли строка палиндромом
    public static boolean isPalindrome(String str) {
        // Удаляем пробелы и приводим строку к нижнему регистру
        str = str.replaceAll("\\s", "").toLowerCase();

        // Переворачиваем строку с помощью существующей функции reverseString
        String reversedStr = reverseString(str);

        // Сравниваем исходную строку с перевернутой
        return str.equals(reversedStr);
    }
}
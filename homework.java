package ru.homework.lesson1;

public class homework {
    public static void main(String[] args) {
        method3(+2);
        method4("Леонид");
        method5(2020);

    }

    //задание 1 без вывода в консоль
    public static double method1(int a, int b, int c, int d) {
        return a * (b + (c / d));

    }
//задание 2 без вывода в консоль
    public static boolean method2(int x1, int x2) {
        int sum = x1 + x2;
        if (sum >= 10 && sum <= 20) return true;
        else return false;
    }
//задание 3 с выводом в консоль
    public static void method3(int x) {
        if(x >= 0) {
            System.out.println("положительное число");
        } else {
            System.out.println("отрицательное число");
        }
    }

//задание 4 с выводом в консоль
    public static void method4(String name) {
        System.out.println("Привет," + name + "!");
    }
// задание 5 с выводом в консоль
    public static void method5(int year) {
        if (!(year % 4 == 0)|| ((year % 100 == 0) && !(year % 400 == 0)))
            System.out.println("не високосный");
        else System.out.println("високосный");
    }




    }
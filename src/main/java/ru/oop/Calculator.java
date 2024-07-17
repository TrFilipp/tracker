package ru.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return x - y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int y) {
        return x / y;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
       Calculator calculator = new Calculator();
       System.out.println(sum(3));
       System.out.println(minus(2));
       System.out.println(calculator.multiply(2));
       System.out.println(calculator.divide(5));
       System.out.println(calculator.sumAllOperation(5));
    }

}

package com.mycompany.javaproject;

import java.util.Scanner;

// Operation Interface
interface Operation {
    double calculate(double a, double b);
}

// Addition Class
class Addition implements Operation {
    public double calculate(double a, double b) {
        return a + b;
    }
}

// Subtraction Class
class Subtraction implements Operation {
    public double calculate(double a, double b) {
        return a - b;
    }
}

// Multiplication Class
class Multiplication implements Operation {
    public double calculate(double a, double b) {
        return a * b;
    }
}

// Division Class
class Division implements Operation {
    public double calculate(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}

// Main Class (Must match filename: Javaproject.java)
public class Javaproject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Operation operation = null;

        System.out.println("=== Simple OOP Calculator ===");

        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        char op = scanner.next().charAt(0);

        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();

        switch (op) {
            case '+':
                operation = new Addition();
                break;
            case '-':
                operation = new Subtraction();
                break;
            case '*':
                operation = new Multiplication();
                break;
            case '/':
                operation = new Division();
                break;
            default:
                System.out.println("Invalid operator.");
                scanner.close();
                return;
        }

        try {
            double result = operation.calculate(a, b);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}

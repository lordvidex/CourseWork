package ru.kpfu.Homework01;

import java.util.Scanner;

/**
 * простая программа-калькулятор
 *
 * @author Owamoyo Oluwadamilola Evans
 */

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("К.А.Л.Ь.К.У.Л.Я.Т.О.Р!!!");
        System.out.println("Введите первое число");
        int number1 = input.nextInt();

        System.out.println("Введите второе число");
        int number2 = input.nextInt();

        System.out.println("Введите знак операции (+,-,*,/,^)");
        String sign = input.next();

        //проверьте если пользователь написал "x" вместо "*"
        if(sign.equals("x"))sign = "*";

        switch (sign){
            case "+":
                System.out.println(number1 + "+" +number2+ " = "+(number1+number2));
                break;
            case "-":
                System.out.println(number1 + "-" +number2+ " = "+(number1-number2));
                break;
            case "*":
                System.out.println(number1 + "*" +number2+" = "+(number1*number2));
                break;
            case "/":
                System.out.println(number1 + "/"+number2 +" = "+((double)number1/number2));
                break;
            case "^":
                System.out.println(number1 + "^" +number2 + " = "+(Math.pow(number1,number2)));
                break;
            default:
                System.out.println("неправильный данный/знак операции");
                break;

        }
    }
}

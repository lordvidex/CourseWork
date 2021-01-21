package ru.kpfu.Homework04;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA
 * Date: 06.10.2020
 * Time: 22:07
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * Desc: A program that writes the binary presentation
 *       of a decimal number
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a whole number: ");
        int number = sc.nextInt();
        String baseTwo = convertNumberToBaseTwo(number);
        System.out.println(baseTwo);
    }

    //overloaded function called only at the start of recursion
    private static String convertNumberToBaseTwo(int number){
        if(number<0){
            return "неверный ввод";
        }
        String s = "";
        s+=number%2;
        return convertNumberToBaseTwo(number/2,s);
    }
    //Recursion method **
    private static String convertNumberToBaseTwo(int number,String s) {
        if(number==0){
            return s;
        }
        s = (number%2)+s;
        return convertNumberToBaseTwo(number/2,s);
    }
}

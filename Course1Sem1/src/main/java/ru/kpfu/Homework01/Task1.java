package ru.kpfu.Homework01;

import java.util.Scanner;

/**
 * программа, которая сообщает, когда магазин работает или нет
 *
 * @author Owamoyo Oluwadamilola Evans
 */

public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int hr = input.nextInt();
        //проверьте если входный данный правильно
        if(hr<0||hr>23){
            System.out.println("неверный данный.");
        }else if(hr==12){
            //проверьте если это время обеда
            System.out.println("Это время обеда.");
        }else if(hr>=8 && hr<=16){
            //рабочий время
            System.out.println("Работает.");
        }else{
            //магазин не работает
            System.out.println("Не работает.");
        }
    }
}

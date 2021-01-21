package ru.kpfu.Homework02;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA
 * Date: 23.09.2020
 * Time: 16:16
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 *
 * Desc: выход целые числа от А до B включительно
 */
public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        System.out.print("Введите число А: ");
        a = sc.nextInt();
        System.out.print("Введите число B: ");
        b = sc.nextInt();
        if(b<=a){
            //проверьте если у нас неправильные данные
            System.out.println("Неправильные данные: A>=B!");
        }else {
            //итерация <<FOR>>
            for (int i = a; i <= b; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.printf("%2d ",i);
                }
                System.out.println();
            }
        }
    }
}

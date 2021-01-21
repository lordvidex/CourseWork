package ru.kpfu.Homework02;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA
 * Date: 23.09.2020
 * Time: 13:51
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 *
 * Desc: решение любого числа N в степени 2
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long power = 0;
        System.out.print("Введите значение N: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            power+=(2*i-1);
        }
        System.out.printf("%d^2 = %d",n,power);
    }
}

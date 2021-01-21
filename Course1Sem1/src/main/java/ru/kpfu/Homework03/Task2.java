package ru.kpfu.Homework03;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA
 * Date: 29.09.2020
 * Time: 22:08
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * Desc: нахождение последнего локального максимума в массиве
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n; //размер массива
        int answer = -1;
        System.out.print("Введите значение n: ");

        //проверка
        try {
            n = sc.nextInt();
        } catch (Exception e) {
            System.out.print("неверная запись");
            return;
        }
        int[] arr = new int[n];
        //случайная генерация элементов массива
        System.out.print("{");
        for (int i = 0; i < n; i++) {
            arr[i] = (int) Math.round(Math.random() * 100);
            System.out.print(arr[i] + (i == n - 1 ? "" : ","));
        }
        System.out.println("}");

        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == 0) {
                if (arr[i] > arr[i + 1]) {
                    answer = i;
                    break;
                }
            } else if (i == arr.length - 1) {
                if (arr[i] > arr[i - 1]) {
                    answer = i;
                    break;
                }
            } else if (arr[i] > arr[i + 1] && arr[i] > arr[i - 1]) {
                answer = i;
                break;
            }
        }
        //проверка
        if (answer == -1) {
            System.out.println("в этом наборе нет локального максимума");
        } else
            System.out.println("порядковый номер последного локального максимума от 0 до " + (n - 1) + ": " + answer);
    }
}

package ru.kpfu.Homework02;

/**
 * Created by IntelliJ IDEA
 * Date: 23.09.2020
 * Time: 12:00
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * 
 * Desc: программа для вывода чисел во вторичной диагонали
 */
public class Task2 {
    public static void main(String[] args) {
        //заданное переменное
        int n = 5;

        for (int i = 0; i < n; i++) {
            for(int j = 0;j<n-i-1;j++){
                System.out.print(".");
            }
            System.out.print(i+1);
            for(int j = 0;j<i;j++){
                System.out.print(".");
            }
            System.out.println();
        }
    }
}

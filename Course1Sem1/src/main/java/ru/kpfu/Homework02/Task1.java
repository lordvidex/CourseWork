package ru.kpfu.Homework02;

/**
 * Created by IntelliJ IDEA
 * Date: 23.09.2020
 * Time: 00:13
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * 
 * Desc: выход трифорс из заданного числа
 */
public class Task1 {
    public static void main(String[] args) {
        //переменное можно изменить на любое число из
        //множества натуральных чисел
        int rows = 3;

        int edgeSpaces = (rows*2)-1;

        //вершина треугольника
        for (int i = 1; i <= rows; i++) {
            for(int j = 0;j<edgeSpaces;j++){
                System.out.print(" ");
            }
            for(int j = 0;j<(2*i-1);j++){
                System.out.print("*");
            }
            for(int j = 0;j<edgeSpaces;j++){
                System.out.print(" ");
            }
            edgeSpaces--;
            System.out.println();
        }

        //основания треугольника
        for(int i =1;i<=rows;i++){
            for(int j = 0;j<edgeSpaces;j++){
                System.out.print(" ");
            }
            for (int j = 0; j < 2*i-1; j++) {
                System.out.print("*");
            }
            for(int j= 0;j<(2*rows-1)-(i-1)*2;j++){
                System.out.print(" ");
            }
            for (int j = 0; j < 2*i-1; j++) {
                System.out.print("*");
            }
            for(int j = 0;j<edgeSpaces;j++){
                System.out.print(" ");
            }
            edgeSpaces--;
            System.out.println();
        }
    }
}

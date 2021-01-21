package ru.kpfu.Homework03;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA
 * Date: 29.09.2020
 * Time: 20:59
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * Desc: проверка того, образует ли массив убывающую последовательность или нет
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;  //размер массива
        int patternBreaker = 0;
        boolean isPatternBroken = false;

        System.out.print("Введите значение n <<размер массива>>: ");

        //проверка
        try {
            n = sc.nextInt();
        }catch(Exception e){
            System.out.print("неверная запись");
            return;
        }

        //массив
        int [] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Введите %d-oe число в массиве: ",i+1);
            arr[i] = sc.nextInt();
            if(i!=0&&arr[i]>=arr[i-1]&&!isPatternBroken){
                patternBreaker = arr[i];
                isPatternBroken = true;
            }
        }
        System.out.println("Ответ: "+ (isPatternBroken?patternBreaker:0));
    }
}

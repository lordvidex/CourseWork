package ru.kpfu.Homework02;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA
 * Date: 23.09.2020
 * Time: 16:29
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 *
 * Desc: проверка наличия нечетной цифры в заданном числе N
 */
public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите любое натуральное число N: ");
        long number = scanner.nextLong();

        //контролер
        boolean isOddDigit = false;

        //итерация <<WHILE>>
        while(number!=0 && !isOddDigit){
            if((number%10)%2==1){
                isOddDigit = true;
            }
            number/=10;
        }
        System.out.println(isOddDigit?"TRUE":"FALSE");
    }
}

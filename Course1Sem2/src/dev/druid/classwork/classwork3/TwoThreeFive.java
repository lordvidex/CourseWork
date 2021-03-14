package dev.druid.classwork.classwork3;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA
 * Date: 24.02.2021
 * Time: 4:30 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class TwoThreeFive {
    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // solve
        long start = System.nanoTime();
        //divideBy235(n);
        char[] newChar = new char[10];
        for (int i = 0; i < newChar.length; i++) {
            System.out.println(newChar[i]);
        }
        System.out.println(System.nanoTime()-start);
    }

    private static void divideBy235(int n) {
        for (int i = 2; i <= n; i++) {
            if(isDivisibleBy235(i)){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    private static boolean isDivisibleBy235(int i) {
        i = divideDown(i,2);
        i = divideDown(i,3);
        i = divideDown(i,5);
        return i == 1;
    }

    private static int divideDown(int i, int d) {
        while(i%d==0){
            i/=d;
        }
        return i;
    }
}

package dev.druid.homework.homework26;

import java.util.Scanner;

/**
 * Created by longelliJ IDEA
 * Date: 17.05.2021
 * Time: 3:07 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Main {
    private static long[] memo;
    private static long fibWithoutMemo(long n){
        if(n==1||n==2){
            return 1;
        }
        return fibWithoutMemo(n-1)+fibWithoutMemo(n-2);
    }
    private static void initMemo(int n){
        memo = new long[(n+1)];
        memo[1] = 1;
        memo[2] = 1;
        for (int i = 3; i <= n; i++) {
            memo[i] = -1;
        }
    }
    private static long fibWithMemo(int n){
       // prepare the memo
        if(memo == null){
            initMemo(n);
        }
        if(memo[n] != -1){
            return memo[n];
        }
        long result = fibWithMemo(n-1)+fibWithMemo(n-2);
        memo[n] = result;
        return memo[n];
    }
    public static void main(String[] args) {
        System.out.println("Task 1");
        task1();
        System.out.println("Task 2");
        task2();


    }

    private static void task2() {
        int[] coins = new int[]{1,2,5};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount: ");
        int n = sc.nextInt();
        int ans = 0;
        while(n!=0){
            for (int i = coins.length-1; i >= 0; i--) {
                if(n-coins[i]>=0){
                    n-=coins[i];
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans+" coins");
    }

    private static void task1() {
        int n = 40;
        long time = System.nanoTime();
        System.out.println(fibWithoutMemo(n));
        System.out.printf("Without memo: %d nanoSeconds%n", System.nanoTime()-time);
        time = System.nanoTime();
        System.out.println(fibWithMemo(n));
        System.out.printf("With memo: %d nanoSeconds%n",System.nanoTime()-time);
    }
}

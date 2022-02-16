package dev.druid.classwork.classwork27;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA
 * Date: 24.05.2021
 * Time: 3:13 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class Main {
    private static void solve(int n){
        fo(n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solve(n);

    }
    private static void fo(int n){
        int[] arr = new int[n+1];
        Arrays.fill(arr,-1);
        arr[1] = 0;
        for (int i = 2; i <= n; i++) {
            int min = arr[i-1];
            if(i%2==0){
                min = Math.min(min,arr[i/2]);
            }
            if(i%3==0){
                min = Math.min(min,arr[i/3]);
            }
            arr[i] = min+1;
        }
        System.out.println(arr[n]);
    }
}

package dev.druid.classwork.classwork3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA
 * Date: 24.02.2021
 * Time: 4:34 PM
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * <p>
 * Desc:
 */
public class TwoThreeFiveQueue {
    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // solve
        long start = System.nanoTime();
        divideBy235(n);
        System.out.println(System.nanoTime()-start);
    }
    public static int minQueue(Queue<Integer> q2,
                               Queue<Integer> q3,
                               Queue<Integer> q5){
        int min;
        int from = 2;
        if(q2.peek()<q3.peek()){
            min = q2.peek();
        }else{
            from = 3;
            min = q3.peek();
        }
        if(q5.peek()<min){
            min = q5.remove();
        }else{
            if (from == 2) {
                q2.remove();
            } else {
                q3.remove();
            }
        }
        return min;
    }
    private static int minOfQueuesHeads(Queue<Integer> q2,
                                        Queue<Integer> q3,
                                        Queue<Integer> q5) {
        // find minimum
        // don't forget to remove minimum
        int a2 = q2.peek();
        int a3 = q3.peek();
        int a5 = q5.peek();
        int whois;
        int min;
        if (a2 < a3) {
            whois = 2;
            min = a2;
        } else {
            whois = 3;
            min = a3;
        }
        if (a5 < min) {
            whois = 5;
            min = a5;
        }
        return switch (whois) {
            case 2 -> q2.remove();
            case 3 -> q3.remove();
            case 5 -> q5.remove();
            default -> min;
        };
    }
    private static void divideBy235(int n) {
        Queue<Integer> q2 = new LinkedList<>(){{
            offer(2);
        }};
        Queue<Integer> q3 = new LinkedList<>(){{
            offer(3);
        }};
        Queue<Integer> q5 = new LinkedList<>(){{
            offer(5);
        }};

        int num = 1;

        do {
            int oldNum = num;
            num = minOfQueuesHeads(q2, q3, q5);
            if (oldNum != num) {
                System.out.print(num + " ");
                q2.offer(2 * num);
                q3.offer(3 * num);
                q5.offer(5 * num);
            }
        }
        while (num < n);
        System.out.println();
    }
}

package ru.kpfu.classwork1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Numbers numbers = new Numbers();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        for (int i = 0; i < 20; i++) {
            numbers.add(i);
        }
        numbers.removeAll(5);
        numbers.removeAll(0);
        System.out.println(numbers.size());
        System.out.println(Arrays.toString(numbers.getNumbers()));
    }
}

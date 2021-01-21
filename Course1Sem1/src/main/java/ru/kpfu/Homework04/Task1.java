package ru.kpfu.Homework04;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA
 * Date: 06.10.2020
 * Time: 21:56
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * Desc: method to check for a palindrome in a string
 */
public class Task1 {
    public static boolean isPalindrome(String string){
        if(string.length()<=1){
            return true;
        }
        if(string.charAt(0)!=string.charAt(string.length()-1)){
            return false;
        }
        return isPalindrome(string.substring(1,string.length()-1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any string: ");
        String myString = sc.next();
        boolean myStringIsPalindrome = isPalindrome(myString);
        System.out.println("The String \""+myString+"\" is "+(myStringIsPalindrome?"":"NOT ")+"a palindrome");
    }
}

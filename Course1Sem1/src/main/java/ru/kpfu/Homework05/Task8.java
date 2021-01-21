package ru.kpfu.Homework05;

/**
 * Created by IntelliJ IDEA
 * Date: 19.10.2020
 * Time: 03:09
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * Desc: количество каждой буквы в строке
 */
public class Task8 {
    public static void analyzeText(String myString){
        myString = myString.toLowerCase();
        int [] counts = new int[26];
        for(int i = 0;i<myString.length();i++){
            if(myString.charAt(i)>='a'&&myString.charAt(i)<='z'){
                counts[myString.charAt(i)-'a']++;
            }
        }
        for (int i = 0; i < counts.length; i++) {
            if(i==13) System.out.println();
            System.out.print((char)(i+'a')+": "+counts[i]+", ");
        }
    }
    public static void main(String[] args) {
        String text = "In a wolf pack, there is only one alpha, few betas and many omegas";
        analyzeText(text);
    }
}

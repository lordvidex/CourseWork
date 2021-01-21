package ru.kpfu.Homework05;

/**
 * Created by IntelliJ IDEA
 * Date: 18.10.2020
 * Time: 03:50
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * Desc: количество гласных букв в русской строке
 */
public class Task3 {
    public static int vowelCount(String str){
        int count = 0;
        char[] vowels = {'а','э','ы','у','о','я','е','ё','ю','и'};
        for (int i = 0; i < str.length(); i++) {
            for (char vowel : vowels) {
                if (str.charAt(i) == vowel || str.charAt(i) == vowel - 32) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String myString = "я ,так написал а вы уже это увидели..";
        System.out.printf("количество гласных букв: %d",vowelCount(myString));
    }
}

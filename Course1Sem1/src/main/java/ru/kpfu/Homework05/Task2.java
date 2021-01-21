package ru.kpfu.Homework05;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA
 * Date: 18.10.2020
 * Time: 02:52
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * Desc: преобразование начала русской буквы на заглавную букву
 */
public class Task2 {
    public static String capitalizeString(String myString){
        String [] stringLists;
        stringLists = myString.split(" ");
        for(int i = 0; i<stringLists.length; i++){
            if(stringLists[i].length()!=0){
                stringLists[i] = stringLists[i].
                        replaceFirst("^[а-я]",""+(char)(stringLists[i].charAt(0)-32));
            }
        }
        return String.join(" ",stringLists);
    }
    public static void main(String[] args) {
        String myString = "я ,так написал а вы уже это увидели..";
        System.out.println(capitalizeString(myString));
    }
}

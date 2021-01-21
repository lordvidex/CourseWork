package ru.kpfu.Homework05;

/**
 * Created by IntelliJ IDEA
 * Date: 17.10.2020
 * Time: 21:00
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 *
 * Desc: програма который проверяет если начало и конец слова в строке равны
 */
public class Task1 {
    //функция..
    public static int checkStartAndEnd(String myString){
        int count = 0;
        String [] words = myString.split("\\s+");
        if(myString.length()==0){
            return 0;
        }
        for(String word: words) {
            word = word.replaceAll("[^А-Я]","");
            System.out.println(word);
            if(word.charAt(0)==word.charAt(word.length()-1))count++;
        }
        return count;
    }

    public static void main(String[] args) {
        //только русские слова!!
        String myString = "МЕНЯ  ЗОВУТ ОВАМОЙО ЭВАНС И Я ТСТУДЕНТ,, КФУ";
        System.out.printf("количество слов, которые начинаются и заканчиваются одной и той же буквой в строке \"%s\": %d",
                myString,
                checkStartAndEnd(myString)
        );
    }
}

package ru.kpfu.Homework06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA
 * Date: 17.10.2020
 * Time: 21:00
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 *
 * Desc: программа которая Выводит первые 10 сгенерированных чисел,
 * в которых есть как минимум два раза встречается группа из 2 четных цифр
 * и показать сколько раз мы cгенерировали, прежде чем получить 10 идеальные числа
 *
 * */

public class Task4 {
    public static void main(String[] args) {
        generateAtLeastTwoEvenPairs();
    }

    //checks for even counts using RegExp
    public static int evenPairCount(int val){
        int count = 0;
        Pattern pattern = Pattern.compile("[02468]{2}");
        Matcher matcher = pattern.matcher(val+"");
        while(matcher.find()){
            count++;
        }
        return count;
    }

    //****generator method
    public static void generateAtLeastTwoEvenPairs() {
        int findCount = 0;
        int loopCount = 0;
        while(findCount!=10){
            int value = (int)(Math.random()*10E8);
            int _evenPairCount = evenPairCount(value);
            if(_evenPairCount>=2){
                System.out.println(value);
                findCount++;
            }
            loopCount++;
        }
        System.out.println("Количество сгенерированных чисел: "+loopCount);
    }
}

package ru.kpfu.Homework06;
import java.util.Scanner;
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
 * Desc: программа, которая выводит true если в строке есть вещественное число с периодом
 * и false если нет.
 *
 */
public class Task2 {
    public static boolean isPeriodicDecimal(String str){
        Pattern pattern = Pattern.compile("[+-]?(?:\\d+)[.,]\\d*\\(\\d+\\)$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    public static void main(String[] args) {
        String[] decimals = new String[]{"-0,(43)","12.(1)31","10.(3)","32.(2)32","0,5","-0,001","+11.25(6)"};
        for(String str: decimals){
            System.out.println(str+": "+isPeriodicDecimal(str));
        }
    }
}

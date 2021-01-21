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
 * Desc: программа с использованием регулярных выражений, которая выведет номера строк
 * только и только тогда когда строка состоит
 * либо только из нулей, либо только из единиц, либо нули и единицы в ней чередуются
 */

public class Task3 {
    public static void isPerfectBinary(String[] binaries){
        Pattern pattern = Pattern.compile("(01)+0?|(10)+1?|1+|0+");
        for (int i = 0; i < binaries.length; i++) {
            Matcher matcher = pattern.matcher(binaries[i]);
            if(matcher.matches()){
                System.out.println(i+": "+matcher.group());
            }
        }
    }

    public static void main(String[] args) {
        String[] binaries = new String[]{
                "010101",
                "11",
                "00",
                "101",
                "0110",
                "001",
                "11101"

        };
        isPerfectBinary(binaries);
    }
}

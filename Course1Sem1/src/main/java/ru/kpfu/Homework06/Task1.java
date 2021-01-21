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
 * Desc: программа, которая выводит true если даты и времени в промежутке
 * с 6 марта 1237 12:00 по 27 февраля 1978 21:35 в формате MM/DD/YYYY HH:MM
 */
public class Task1 {
    /**
     * если один из них работает.. то дата и время в промежутке
     * @1ST_MATCH: 03/06/1237 (12-23):MM
     * @2ND_MATCH: 03/(07-31)/1237 HH:MM
     * @3RD_MATCH: (04-12)/DD/1237 HH:MM
     * @4TH_MATCH: MM/DD/(1238-1977) HH:MM
     * @5TH_MATCH: 01/DD/1978 HH:MM
     * @6TH_MATCH: 02/(01-26)/1978 HH:MM
     * @7TH_MATCH: 02/27/1978 (00:00-21:35)
     */
    public static boolean withinDateRange(String dateTime){
        boolean matched = false;
        String regExp = "((?:03/06/1237\\s(?:1[2-9]|2[0-3]):(?:[0-5][0-9]))|(?:03/(?:0[7-9]|[1-2][0-9]|3[0-1])/1237\\s(?:[0-1][0-9]|2[0-3]):(?:[0-5][0-9]))|(?:(?:(?:0[4-9]|1[0-2])/(?:0[1-9]|[1-2][0-9]|3[0-1])/1237)\\s(?:[0-1][0-9]|2[0-3]):(?:[0-5][0-9]))|(?:(?:0[1-9]|1[0-2])/(?:0[1-9]|[1-2][0-9]|3[0-1])/1(?:23[8-9]|2[4-9][0-9]|[3-8]\\d{2}|9[0-6]\\d|97[0-7])\\s(?:[0-1][0-9]|2[0-3]):(?:[0-5][0-9]))|(?:(?:01/(?:0[1-9]|[1-2][0-9]|3[0-1])/1978)\\s(?:[0-1][0-9]|2[0-3]):(?:[0-5][0-9]))|(?:(?:02/(?:0[1-9]|1[0-9]|2[0-6])/1978)\\s(?:[0-1][0-9]|2[0-3]):(?:[0-5][0-9]))|(?:02/27/1978\\s(?:(?:(?:(?:[0-1][0-9])|20):(?:[0-5][0-9]))|(?:21:(?:[0-2][0-9]|3[0-5])))))";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(dateTime);
        while(matcher.find()){
            if(!matched) System.out.println("MATCHES: ");
            matched = true;
            System.out.println(matcher.group());
        }
        return matched;
    }
    public static void main(String[] args) {
        System.out.println("MM/DD/YYYY HH:MM \n");
        String[] dateTimes = new String[]{
                "02/27/1978 21:3306/03/1238 12:00",
                "06/03/1237 12:00",
                "12/01/1245 01:45",
                "02/22/1978 12:00",
                "03/05/1237 12:05"
        };
        for(String str: dateTimes){
            System.out.println("Date within range: "+withinDateRange(str)+"\n");
        }
    }
}

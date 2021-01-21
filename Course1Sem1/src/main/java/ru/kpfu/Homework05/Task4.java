package ru.kpfu.Homework05;

/**
 * Created by IntelliJ IDEA
 * Date: 18.10.2020
 * Time: 04:03
 *
 * @author lordvidex
 * Name: Овамойо Олувадамилола Эванс
 * Desc: преобразование предложение с издиточными пробелами чтобы между словами был ровно один пробел
 */
public class Task4 {
    public static String oneSpace(String str){
        StringBuilder newStr = new StringBuilder();
        boolean firstSpace = false;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)!=' '){
                firstSpace = false;
                newStr.append(str.charAt(i));
            }else{
                if(!firstSpace){
                    firstSpace = true;
                    newStr.append(' ');
                }
            }
        }
        return newStr.toString();
    }
    public static void main(String[] args) {
        String myString = "ac,   ds   qw r wee    q a    a    gv   v   x    x   as";
        long startTime = System.nanoTime();
        System.out.println(oneSpace(myString));
        System.out.printf("время выполнения задачи: %f миллисекунды",(System.nanoTime()-startTime)/10e6);
    }
}
